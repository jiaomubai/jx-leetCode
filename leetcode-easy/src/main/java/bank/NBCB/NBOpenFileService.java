package bank.NBCB;

import com.nbcb.sdk.aes.service.ApproveDevService;
import com.nbcb.sdk.aes.service.BuildErrorRespService;
import com.nbcb.sdk.aes.service.CheckTokenService;
import com.nbcb.sdk.aes.param.ArrayConfig;
import com.nbcb.sdk.aes.param.ConfigFile;
import com.nbcb.sdk.aes.param.KeyStoreFactory;
import com.nbcb.sdk.aes.utils.RandomKey;
import com.nbcb.sdk.SDKRequestHead;
import com.nbcb.sdk.aes.service.PackHeadService;
import com.nbcb.sdk.aes.service.URLConnectionAdapter;
import com.nbcb.sdk.aes.service.CommonSecurityService;
import com.nbcb.sdk.aes.service.CoverHeadService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nbcb.sdk.aes.exception.SDKException;
import com.nbcb.sdk.aes.exception.SDKExceptionEnums;
import com.nbcb.sdk.aes.utils.FileUtils;
import com.nbcb.sdk.file.FileDownloadResponse;
import com.nbcb.sdk.gm.SM3Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author jiaoxian
 * @name bank.NBCB
 * @date 2023/8/24 11:05
 * @description TODO
 */
public class NBOpenFileService {

    private static final Log log = LogFactory.getLog(NBOpenFileService.class);
    public static final String SERVICE_BIG_FILE_UPLOAD = "bigFileUpload";
    public static final String SERVICE_BIG_FILE_DOWNLOAD = "bigFileDownload";
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    public NBOpenFileService() {
    }

    public static String sendBigFileDownload(String channelNo, String fileId, String dirPath) throws Exception {
        String respValue = "";
        try {
            String json = NBCBOpenSDK.getFileDownloadRequest(fileId, channelNo);
            Map<String, Object> localMap = KeyStoreFactory.getInstance().getTokenMap();
            if (localMap == null || localMap.size() <= 0) {
                localMap = NBCBOpenSDK.approveDev();
            }
            String token = String.valueOf(localMap.get("APP_Token"));
            if (null == token || "".equals(token)) {
                localMap = NBCBOpenSDK.approveDev();
                token = String.valueOf(localMap.get("APP_Token"));
            }
            String expirein = String.valueOf(localMap.get("expirein"));
            String updatetime = String.valueOf(localMap.get("updatetime"));
            if (!KeyStoreFactory.getInstance().checkTokenVaild(expirein, updatetime)) {
                localMap = NBCBOpenSDK.approveDev();
                token = String.valueOf(localMap.get("APP_Token"));
            }
            if (!"000000".equalsIgnoreCase((new StringBuilder()).append(localMap.get("Txn_Rsp_Cd_Dsc")).append("").toString()) || !"000000".equalsIgnoreCase((new StringBuilder()).append(localMap.get("SYS_RESP_CODE")).append("").toString())) {
                return BuildErrorRespService.buildErrorResp(NBCBOpenSDK.objToStr(localMap.get("SYS_RESP_CODE")), NBCBOpenSDK.objToStr(localMap.get("SYS_RESP_DESC")));
            }
            byte[] cntrKey = (byte[])localMap.get("CntrKey");
            byte[] syncKey = (byte[])localMap.get("SyncKey");
            byte[] randomKey = RandomKey.getKey(16);
            SDKRequestHead head = PackHeadService.packReqHeadByJson("", json, token);
            json = CoverHeadService.cover(head, json);
            byte[] reqJson = CommonSecurityService.encryService(json, randomKey, cntrKey, syncKey);
            byte[] resp = null;
            log.info("请求报文密文：" + new String(reqJson, "UTF-8"));
            resp = postDownFile(null, "bigFileDownload", reqJson, dirPath, head, null, randomKey);
            log.info("响应报文密文：" + new String(resp, "UTF-8"));
            String respStr = new String(resp, "UTF-8");
            if (!ApproveDevService.IsCliperText(respStr)) {
                return respStr;
            }
            if (NBCBOpenSDK.containsRetCode(respStr)) {
                return respStr;
            }
            Map<String, Object> decryMap = CommonSecurityService.decryService(resp, randomKey, cntrKey);
            respValue = (String)decryMap.get("respValue");
            boolean dev = ((Boolean)decryMap.get("dev")).booleanValue();
            CheckTokenService.refreshToken(dev);
            handleFileDowloadRes(new String(randomKey, "utf-8"), dirPath, respValue);
        } catch (Exception e) {
            if (log.isErrorEnabled()) {
                log.error("执行业务调用异常", e);
            }
            if (e instanceof SDKException) {
                respValue = BuildErrorRespService.buildErrorResp((SDKException)e);
            } else {
                throw e;
            }
        }
        return respValue;
    }
    private static void handleFileDowloadRes(String randomKeyStr, String dirPath, String res) throws Exception {
        String localFilePath = dirPath + File.separator + randomKeyStr + "_tmp";
        try {
            JSONObject resJson = JSONObject.parseObject(res);
            FileDownloadResponse fileDownloadResponse = (FileDownloadResponse)JSONObject.parseObject(JSON.toJSONString(resJson.getJSONObject("Data")), FileDownloadResponse.class);
            if (!"0000".equals(fileDownloadResponse.getRetCode())) {
                return;
            }
            if (dirPath == null) {
                return;
            }
            String nSign = SM3Utils.encryptStr(new File(localFilePath));
            if (!nSign.equals(fileDownloadResponse.getData().getSign())) {
                throw new SDKException(SDKExceptionEnums.FILE_SIGN_ERROR);
            }
            String originalFilename = fileDownloadResponse.getData().getOriginalFilename();
            File dirFile = new File(dirPath);
            if (dirFile.isFile()) {
                throw new RuntimeException("dirPath必须为目录");
            }
            if (!dirFile.exists()) {
                dirFile.mkdirs();
            }
            (new File(localFilePath)).renameTo(new File(dirPath + File.separator + originalFilename));
        } finally {
            File f = new File(localFilePath);
            if (f.exists()) {
                f.delete();
            }
        }

    }

    private static byte[] postDownFile(String appkey, String urlStr, byte[] reqJson, String dirPath, SDKRequestHead head, Map<String, String> header, byte[] randomKey) throws Exception {
        if (appkey == null) {
            urlStr = ConfigFile.MPUBLICURL + "/" + urlStr;
        } else {
            urlStr = ((ArrayConfig)ConfigFile.configMap.get(appkey)).getMPUBLICURL() + "/" + urlStr;
        }
        if (log.isDebugEnabled()) {
            log.debug("url=[" + urlStr + "]");
            log.debug("请求报文=[" + new String(reqJson) + "]");
        }
        URLConnectionAdapter urlConnectionAdapter = null;
        OutputStream OutputStream = null;
        InputStream inputStream = null;
        FileInputStream fileInputStream = null;
        String localFilePath = dirPath + File.separator + new String(randomKey, "utf-8");
        RandomAccessFile randomAccessFile = null;
        RandomAccessFile tmpAccessFile = null;
        try {
            URL url = new URL(urlStr);
            URLConnection urlConnection = url.openConnection();
            urlConnectionAdapter = new URLConnectionAdapter(urlStr, urlConnection);
            addRequestHead(urlStr, head, urlConnectionAdapter, header);
            urlConnection.connect();
            OutputStream = urlConnection.getOutputStream();
            OutputStream.write(reqJson);
            OutputStream.flush();
            int code = urlConnectionAdapter.getResponseCode();
            inputStream = urlConnectionAdapter.getInputStream();
            byte[] orginalRespArr = new byte[4096];
            File dirFile = new File(dirPath);
            if (dirFile.isFile()) {
                throw new RuntimeException("dirPath必须为目录");
            }
            if (!dirFile.exists()) {
                dirFile.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(localFilePath);
            FileUtils.copy(inputStream, fileOutputStream);
            if (200 != code) {
                if (log.isErrorEnabled()) {
                    log.error("HTTP 响应异常,ResponseCode=[" + code + "]");
                }
                throw new SDKException(SDKExceptionEnums.HTTPCONN_ERROR);
            }
            randomAccessFile = new RandomAccessFile(localFilePath, "rw");
            randomAccessFile.read(orginalRespArr);
            byte[] respByteArr = removeByteArrNull(orginalRespArr);
            randomAccessFile.seek(4096L);
            tmpAccessFile = new RandomAccessFile(localFilePath + "_tmp", "rw");
            int byteCount = 0;
            byte[] buffer = new byte[4096];
            while ((byteCount = randomAccessFile.read(buffer)) != -1) {
                tmpAccessFile.write(buffer, 0, byteCount);
            }
            return respByteArr;
        } catch (Exception e) {
            if (e instanceof SDKException) {
                throw e;
            }
            if (log.isErrorEnabled()) {
                log.error("通讯模块异常,通讯地址=[" + urlStr + "]", e);
            }
            throw new SDKException(SDKExceptionEnums.POST_ERROR);
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    if (log.isErrorEnabled()) {
                        log.error("关闭文件输入流异常", e);
                    }
                }
            }
            if (OutputStream != null) {
                try {
                    OutputStream.close();
                } catch (IOException e) {
                    if (log.isErrorEnabled()) {
                        log.error("关闭输出流异常", e);
                    }
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    if (log.isErrorEnabled()) {
                        log.error("关闭输入流异常", e);
                    }
                }
            }
            if (urlConnectionAdapter != null) {
                urlConnectionAdapter.disconnect();
            }
            FileUtils.closeRandomAccessFile(new RandomAccessFile[] { randomAccessFile, tmpAccessFile });
            if ((new File(localFilePath)).exists()) {
                (new File(localFilePath)).delete();
            }
        }
    }


    private static void addRequestHead(String urlStr, SDKRequestHead head, URLConnectionAdapter mConnection, Map<String, String> header) throws Exception {
        mConnection.setDoOutput(true);
        mConnection.setDoInput(true);
        mConnection.setConnectTimeout(((ArrayConfig)ConfigFile.configMap.get(head.getAPP_Key())).getCONNECT_TIMEOUT());
        mConnection.setReadTimeout(((ArrayConfig)ConfigFile.configMap.get(head.getAPP_Key())).getREAD_TIMEOUT());
        mConnection.setRequestMethod("POST");
        mConnection.setUseCaches(false);
        if (header != null && header.size() > 0) {
            for (String key : header.keySet()) {
                mConnection.addRequestProperty(key, header.get(key));
            }
        }
        mConnection.addRequestProperty("APP_Key", head.getAPP_Key());
        mConnection.addRequestProperty("APP_Token", head.getAPP_Token());
        mConnection.addRequestProperty("IP_Adr", head.getIP_Adr());
        mConnection.addRequestProperty("MAC_Adr", head.getMAC_Adr());
        mConnection.addRequestProperty("Content-Type", "application/json");
        mConnection.addRequestProperty("Txn_ModDsc", head.getTxn_ModDsc());
        mConnection.addRequestProperty("URI", urlStr);
    }

    public static byte[] removeByteArrNull(byte[] arr) {
        int nullStartIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && arr.length > i + 1 && arr[i + 1] == 0) {
                nullStartIndex = i;
                break;
            }
        }
        return subarray(arr, 0, nullStartIndex);
    }

    public static byte[] subarray(byte[] array, int startIndexInclusive, int endIndexExclusive) {
        if (array == null) {
            return null;
        }
        if (startIndexInclusive < 0) {
            startIndexInclusive = 0;
        }
        if (endIndexExclusive > array.length) {
            endIndexExclusive = array.length;
        }
        int newSize = endIndexExclusive - startIndexInclusive;
        if (newSize <= 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] subarray = new byte[newSize];
        System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
        return subarray;
    }

    public static void main(String[] args) {

        Date date = new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String nowTime = sdf.format(date);
        System.out.println(nowTime);

        String uUid = UUID.randomUUID().toString();
        System.out.println(uUid);
        uUid = uUid.replace("-", "");
        uUid = uUid.substring(0, 15);
        System.out.println(uUid);



        System.out.println("NBOpenFileService");
    }



}
