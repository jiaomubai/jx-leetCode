package bank.NBCB;

//import com.nbcb.sdk.OpenSDK;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import com.nbcb.bouncycastle.util.encoders.Base64;
import com.nbcb.callback.CommonSecurityServiceMerchant;
import com.nbcb.sdk.AbstractBussinessBean;
import com.nbcb.sdk.SDKRequestHead;
import com.nbcb.sdk.aes.exception.SDKException;
import com.nbcb.sdk.aes.exception.SDKExceptionEnums;
import com.nbcb.sdk.aes.param.ArrayConfig;
import com.nbcb.sdk.aes.param.ConfigFile;
import com.nbcb.sdk.aes.param.ConfigParam;
import com.nbcb.sdk.aes.param.HeaderConfig;
import com.nbcb.sdk.aes.param.KeyStoreFactory;
import com.nbcb.sdk.aes.param.Version;
import com.nbcb.sdk.aes.service.ApproveDevService;
import com.nbcb.sdk.aes.service.BuildErrorRespService;
import com.nbcb.sdk.aes.service.BussinessAdapterService;
import com.nbcb.sdk.aes.service.CheckTokenService;
import com.nbcb.sdk.aes.service.CommonSecurityService;
import com.nbcb.sdk.aes.service.CoverHeadService;
import com.nbcb.sdk.aes.service.FieldCheckoutService;
import com.nbcb.sdk.aes.service.OpenFileService;
import com.nbcb.sdk.aes.service.PackHeadService;
import com.nbcb.sdk.aes.utils.FileUtils;
import com.nbcb.sdk.aes.utils.RandomKey;
import com.nbcb.sdk.file.FileDownloadResponse;
import com.nbcb.sdk.file.FileUploadRequest;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author jiaoxian
 * @name bank.NBCB
 * @date 2023/8/17 20:42
 * @description TODO
 */
public class NBCBOpenSDK {

    private static final Log log = LogFactory.getLog(NBCBOpenSDK.class);

    private static Boolean isInit = Boolean.valueOf(false);

//    public static boolean init(InputStream stream, String privatekey) {
//        return initLocal(stream, privatekey).booleanValue();
//    }

    public static boolean init(String path, String privatekey) {
        return initLocal(path, privatekey).booleanValue();
    }
//
//    public static void dynamicInit(ConfigParam configParam, boolean coverFlag) throws SDKException {
//        ConfigFile.addConfig(configParam, coverFlag);
//    }

    private static Boolean initLocal(Object path, String privatekey) {
        synchronized (isInit) {
            try {
                if (path instanceof InputStream) {
                    InputStream localStream = (InputStream) path;
                    ConfigFile.readConfig(localStream, privatekey);
                } else {
                    String localPath = (String) path;
                    ConfigFile.readConfig(localPath, privatekey);
                }
                ConfigFile.PRIVATEKEY = privatekey;
                KeyStoreFactory.getInstance();
                isInit = Boolean.valueOf(!isInit.booleanValue());
                TypeUtils.compatibleWithJavaBean = true;
            } catch (Exception e) {
                if (log.isErrorEnabled()) {
                    log.error("初始化失败", e);
                }
                return Boolean.valueOf(false);
            }
            log.info("初始化成功......");
        }
        return isInit;
    }

    public static Map<String, Object> approveDev() throws SDKException {
        try {
            byte[] randomKey = RandomKey.getKey(16);
            SDKRequestHead head = PackHeadService.packReqHeadByBean(null, "");
            log.info("NBCBOpenSDK.approveDev.PackHeadService.packReqHeadByBean:" + JSON.toJSONString(head));
            byte[] cntrKey = RandomKey.getKey(16);
            log.info("NBCBOpenSDK.approveDev.cntrKey:" + new String(cntrKey));
            byte[] syncKey = RandomKey.getKey(16);
            log.info("NBCBOpenSDK.approveDev.syncKey:" + new String(syncKey));
            byte[] reqJson = ApproveDevService.encry(head, randomKey, cntrKey, syncKey);
            log.info("NBCBOpenSDK.approveDev.reqJson:" + new String(reqJson));
            byte[] resp = BussinessAdapterService.post("approveDev", reqJson, head);
            log.info("NBCBOpenSDK.approveDev.resp:" + new String(resp));
            ApproveDevService.decry(resp, randomKey, cntrKey, syncKey);
        } catch (Exception e) {
            if (log.isErrorEnabled()) {
                log.error("执行开发者认证异常", e);
            }
            throw new SDKException(SDKExceptionEnums.APPROVEDEV_FAIL);
        }
        return KeyStoreFactory.getInstance().getTokenMap();
    }

//    public static Map<String, Object> approveDev(String appkey) throws SDKException {
//        try {
//            byte[] randomKey = RandomKey.getKey(16);
//            SDKRequestHead head = PackHeadService.packReqHeadByBean(appkey, null, "");
//            byte[] cntrKey = RandomKey.getKey(16);
//            byte[] syncKey = RandomKey.getKey(16);
//            byte[] reqJson = ApproveDevService.encry(appkey, head, randomKey, cntrKey, syncKey);
//            byte[] resp = BussinessAdapterService.post(appkey, "approveDev", reqJson, head);
//            ApproveDevService.decry(appkey, resp, randomKey, cntrKey, syncKey);
//        } catch (Exception e) {
//            if (log.isErrorEnabled()) {
//                log.error("执行开发者认证异常", e);
//            }
//            throw new SDKException(SDKExceptionEnums.APPROVEDEV_FAIL);
//        }
//        return ((ArrayConfig) ConfigFile.configMap.get(appkey)).getKEYSTOREFACTORY().getTokenMap();
//    }
//
//    public static int send(AbstractBussinessBean bean) throws Exception {
//        ParserConfig.getGlobalInstance().setAsmEnable(false);
//        int returnStatus = 0;
//        try {
//            Map<String, Object> localMap = KeyStoreFactory.getInstance().getTokenMap();
//            if (localMap == null || localMap.size() <= 0) {
//                localMap = approveDev();
//            }
//            String token = String.valueOf(localMap.get("APP_Token"));
//            if (null == token || "".equals(token)) {
//                localMap = approveDev();
//                token = String.valueOf(localMap.get("APP_Token"));
//            }
//            String expirein = String.valueOf(localMap.get("expirein"));
//            String updatetime = String.valueOf(localMap.get("updatetime"));
//            if (!KeyStoreFactory.getInstance().checkTokenVaild(expirein, updatetime)) {
//                localMap = approveDev();
//                token = String.valueOf(localMap.get("APP_Token"));
//            }
//            if (!"000000".equalsIgnoreCase((new StringBuilder()).append(localMap.get("Txn_Rsp_Cd_Dsc")).append("").toString()) || !"000000".equalsIgnoreCase((new StringBuilder()).append(localMap.get("SYS_RESP_CODE")).append("").toString())) {
//                BuildErrorRespService.buildErrorResp(objToStr(localMap.get("SYS_RESP_CODE")), objToStr(localMap.get("SYS_RESP_DESC")));
//                return 1;
//            }
//            byte[] cntrKey = (byte[]) localMap.get("CntrKey");
//            byte[] syncKey = (byte[]) localMap.get("SyncKey");
//            FieldCheckoutService.check(bean);
//            SDKRequestHead head = PackHeadService.packReqHeadByBean(bean, token);
//            byte[] randomKey = RandomKey.getKey(16);
//            byte[] reqJson = CommonSecurityService.encryService(bean, head, randomKey, cntrKey, syncKey);
//            byte[] resp = BussinessAdapterService.post(bean.getUrl(), reqJson, head);
//            boolean dev = CommonSecurityService.decryService(bean, resp, randomKey, cntrKey);
//            CheckTokenService.CheckToken(bean);
//        } catch (Exception e) {
//            returnStatus = 1;
//            if (log.isErrorEnabled()) {
//                log.error("执行业务调用异常", e);
//            }
//            if (e instanceof SDKException) {
//                BuildErrorRespService.buildErrorResp((SDKException) e, bean);
//            } else {
//                throw e;
//            }
//        }
//        return returnStatus;
//    }
//
    public static String send(String productID, String serviceID, String json) throws Exception {
        String respValue = "";
        try {
            Map<String, Object> localMap = KeyStoreFactory.getInstance().getTokenMap();
            if (localMap == null || localMap.size() <= 0) {
                localMap = approveDev();
            }
            String token = String.valueOf(localMap.get("APP_Token"));
            if (null == token || "".equals(token)) {
                localMap = approveDev();
                token = String.valueOf(localMap.get("APP_Token"));
            }
            String expirein = String.valueOf(localMap.get("expirein"));
            String updatetime = String.valueOf(localMap.get("updatetime"));
            if (!KeyStoreFactory.getInstance().checkTokenVaild(expirein, updatetime)) {
                localMap = approveDev();
                token = String.valueOf(localMap.get("APP_Token"));
            }
            if (!"000000".equalsIgnoreCase((new StringBuilder()).append(localMap.get("Txn_Rsp_Cd_Dsc")).append("").toString()) || !"000000".equalsIgnoreCase((new StringBuilder()).append(localMap.get("SYS_RESP_CODE")).append("").toString())) {
                return BuildErrorRespService.buildErrorResp(objToStr(localMap.get("SYS_RESP_CODE")), objToStr(localMap.get("SYS_RESP_DESC")));
            }
            byte[] cntrKey = (byte[]) localMap.get("CntrKey");
            byte[] syncKey = (byte[]) localMap.get("SyncKey");
            byte[] randomKey = RandomKey.getKey(16);
            SDKRequestHead head = PackHeadService.packReqHeadByJson(productID, json, token);
            log.info("SDKRequestHead:" + JSON.toJSONString(head));
            json = CoverHeadService.cover(head, json);
            byte[] reqJson = CommonSecurityService.encryService(json, randomKey, cntrKey, syncKey);
            byte[] resp = null;
            log.info("请求报文密文:" + new String(reqJson, "UTF-8"));
            if (productID == null || "".equals(productID)) {
                resp = BussinessAdapterService.post(serviceID, reqJson, head);
            } else {
                resp = BussinessAdapterService.post(productID + "/" + serviceID, reqJson, head);
            }
            log.info("响应报文密文"+ new String(resp, "UTF-8"));
                    String respStr = new String(resp, "UTF-8");
            if (!ApproveDevService.IsCliperText(respStr)) {
                return respStr;
            }
            if (containsRetCode(respStr)) {
                return respStr;
            }
            Map<String, Object> decryMap = CommonSecurityService.decryService(resp, randomKey, cntrKey);
            respValue = (String) decryMap.get("respValue");
            boolean dev = ((Boolean) decryMap.get("dev")).booleanValue();
            CheckTokenService.refreshToken(dev);
        } catch (Exception e) {
            if (log.isErrorEnabled()) {
                log.error("执行业务调用异常", e);
            }
            if (e instanceof SDKException) {
                respValue = BuildErrorRespService.buildErrorResp((SDKException) e);
            } else {
                throw e;
            }
        }
        return respValue;
    }
//
//    public static String send(String appkey, String productID, String serviceID, String json) throws Exception {
//        String respValue = "";
//        try {
//            JSONObject jSONObject1 = null;
//            Map<String, Object> localMap = ((ArrayConfig) ConfigFile.configMap.get(appkey)).getKEYSTOREFACTORY().getTokenMap();
//            if (localMap == null || localMap.size() <= 0) {
//                localMap = approveDev(appkey);
//            }
//            String token = String.valueOf(localMap.get("APP_Token"));
//            if (null == token || "".equals(token)) {
//                localMap = approveDev(appkey);
//                token = String.valueOf(localMap.get("APP_Token"));
//            }
//            String expirein = String.valueOf(localMap.get("expirein"));
//            String updatetime = String.valueOf(localMap.get("updatetime"));
//            if (!KeyStoreFactory.getInstance().checkTokenVaild(expirein, updatetime)) {
//                localMap = approveDev(appkey);
//                token = String.valueOf(localMap.get("APP_Token"));
//            }
//            if (!"000000".equalsIgnoreCase((new StringBuilder()).append(localMap.get("Txn_Rsp_Cd_Dsc")).append("").toString()) || !"000000".equalsIgnoreCase((new StringBuilder()).append(localMap.get("SYS_RESP_CODE")).append("").toString())) {
//                return BuildErrorRespService.buildErrorResp(objToStr(localMap.get("SYS_RESP_CODE")), objToStr(localMap.get("SYS_RESP_DESC")));
//            }
//            byte[] cntrKey = (byte[]) localMap.get("CntrKey");
//            byte[] syncKey = (byte[]) localMap.get("SyncKey");
//            byte[] randomKey = RandomKey.getKey(16);
//            SDKRequestHead head = PackHeadService.packReqHeadByJson(appkey, productID, json, token);
//            json = CoverHeadService.cover(head, json);
//            byte[] reqJson = CommonSecurityService.encryService(json, randomKey, cntrKey, syncKey);
//            byte[] resp = null;
//            JSONObject openHeader = ((ArrayConfig) ConfigFile.configMap.get(appkey)).getOPEN_HEADER();
//            Map<String, String> headerMap = new HashMap<String, String>();
//            if (openHeader != null) {
//                jSONObject1 = openHeader;
//            }
//            log.info("请求报文密文：" + new String(reqJson, "UTF-8"));
//            if (productID == null || "".equals(productID)) {
//                resp = BussinessAdapterService.post(appkey, serviceID, reqJson, head, (Map) jSONObject1);
//            } else {
//                resp = BussinessAdapterService.post(appkey, productID + "/" + serviceID, reqJson, head, (Map) jSONObject1);
//            }
//            log.info("响应报文密文：" + new String(resp, "UTF-8"));
//                    String respStr = new String(resp, "UTF-8");
//            if (!ApproveDevService.IsCliperText(respStr)) {
//                return respStr;
//            }
//            if (containsRetCode(respStr)) {
//                return respStr;
//            }
//            Map<String, Object> decryMap = CommonSecurityService.decryService(resp, randomKey, cntrKey);
//            respValue = (String) decryMap.get("respValue");
//            boolean dev = ((Boolean) decryMap.get("dev")).booleanValue();
//            CheckTokenService.refreshToken(dev, appkey);
//        } catch (Exception e) {
//            if (log.isErrorEnabled()) {
//                log.error("执行业务调用异常", e);
//            }
//            if (e instanceof SDKException) {
//                respValue = BuildErrorRespService.buildErrorResp((SDKException) e);
//            } else {
//                throw e;
//            }
//        }
//        return respValue;
//    }
//
//    public static String send(String appkey, String productID, String serviceID, String json, HeaderConfig headerConfig) throws Exception {
//        String respValue = "";
//        try {
//            Map<String, Object> localMap = ((ArrayConfig) ConfigFile.configMap.get(appkey)).getKEYSTOREFACTORY().getTokenMap();
//            if (localMap == null || localMap.size() <= 0) {
//                localMap = approveDev(appkey);
//            }
//            String token = String.valueOf(localMap.get("APP_Token"));
//            if (null == token || "".equals(token)) {
//                localMap = approveDev(appkey);
//                token = String.valueOf(localMap.get("APP_Token"));
//            }
//            String expirein = String.valueOf(localMap.get("expirein"));
//            String updatetime = String.valueOf(localMap.get("updatetime"));
//            if (!KeyStoreFactory.getInstance().checkTokenVaild(expirein, updatetime)) {
//                localMap = approveDev(appkey);
//                token = String.valueOf(localMap.get("APP_Token"));
//            }
//            if (!"000000".equalsIgnoreCase((new StringBuilder()).append(localMap.get("Txn_Rsp_Cd_Dsc")).append("").toString()) || !"000000".equalsIgnoreCase((new StringBuilder()).append(localMap.get("SYS_RESP_CODE")).append("").toString())){
//                return BuildErrorRespService.buildErrorResp(objToStr(localMap.get("SYS_RESP_CODE")), objToStr(localMap.get("SYS_RESP_DESC")));
//            }
//            byte[] cntrKey = (byte[]) localMap.get("CntrKey");
//            byte[] syncKey = (byte[]) localMap.get("SyncKey");
//            byte[] randomKey = RandomKey.getKey(16);
//            SDKRequestHead head = PackHeadService.packReqHeadByJson(appkey, productID, json, token);
//            json = CoverHeadService.cover(head, json);
//            byte[] reqJson = CommonSecurityService.encryService(json, randomKey, cntrKey, syncKey);
//            byte[] resp = null;
//            Map<String, String> headerMap = new HashMap<String, String>();
//            Map<String, String> httpHeader = headerConfig.getHeader();
//            if (appkey.equals(httpHeader.get("APP_KEY"))) {
//                headerMap = httpHeader;
//            }
//            log.info("请求报文密文：" + new String(reqJson, "UTF-8"));
//            if (productID == null || "".equals(productID)) {
//                resp = BussinessAdapterService.post(appkey, serviceID, reqJson, head, headerMap);
//            } else {
//                resp = BussinessAdapterService.post(appkey, productID + "/" + serviceID, reqJson, head, headerMap);
//            }
//            log.info("响应报文密文：" + new String(resp, "UTF-8"));
//                    String respStr = new String(resp, "UTF-8");
//            if (!ApproveDevService.IsCliperText(respStr)) {
//                return respStr;
//            }
//            if (containsRetCode(respStr)) {
//                return respStr;
//            }
//            Map<String, Object> decryMap = CommonSecurityService.decryService(resp, randomKey, cntrKey);
//            respValue = (String) decryMap.get("respValue");
//            boolean dev = ((Boolean) decryMap.get("dev")).booleanValue();
//            CheckTokenService.refreshToken(dev, appkey);
//        } catch (Exception e) {
//            if (log.isErrorEnabled()) {
//                log.error("执行业务调用异常", e);
//            }
//            if (e instanceof SDKException) {
//                respValue = BuildErrorRespService.buildErrorResp((SDKException) e);
//            } else {
//                throw e;
//            }
//        }
//        return respValue;
//    }
//
//    public static String sendFile(String productID, String channelNo, String filename, byte... bytes) throws Exception {
//        return send(productID, "fileUpload", JSON.toJSONString(getFileUploadRequest(channelNo, filename, bytes)));
//    }
//
//    public static String sendFile(String appKey, String productID, String channelNo, String filename, byte... bytes) throws Exception {
//        return send(appKey, productID, "fileUpload", JSON.toJSONString(getFileUploadRequest(channelNo, filename, bytes)));
//    }
//
//    public static String sendFile(String appKey, String productID, HeaderConfig headerConfig, String channelNo, String filename, byte... bytes) throws Exception {
//        return send(appKey, productID, "fileUpload", JSON.toJSONString(getFileUploadRequest(channelNo, filename, bytes)), headerConfig);
//    }
//
    public static FileDownloadResponse sendFileDownload(String productID, String channelNo, String fileId, String dirPath) throws Exception {
        String res = send(productID, "fileDownload", getFileDownloadRequest(fileId, channelNo));
        return handleFileDowloadRes(fileId, dirPath, res);
    }
//
//    public static FileDownloadResponse sendFileDownload(String appKey, String productID, String channelNo, String fileId, String dirPath) throws Exception {
//        String res = send(appKey, productID, "fileDownload", getFileDownloadRequest(fileId, channelNo));
//        return handleFileDowloadRes(fileId, dirPath, res);
//    }
//
//    public static FileDownloadResponse sendFileDownload(String appKey, String productID, String channelNo, HeaderConfig headerConfig, String fileId, String dirPath) throws Exception {
//        String res = send(appKey, productID, "fileDownload", getFileDownloadRequest(fileId, channelNo), headerConfig);
//        return handleFileDowloadRes(fileId, dirPath, res);
//    }
//
//    public static String sendBigFile(String appkey, String channelNo, String filePath) throws Exception {
//        return OpenFileService.sendBigFile(appkey, channelNo, filePath);
//    }
//
//    public static String sendBigFile(String channelNo, String filePath) throws Exception {
//        return OpenFileService.sendBigFile(channelNo, filePath);
//    }
//
//    public static String sendBigFileDownload(String appkey, String channelNo, String fileId, String dirPath) throws Exception {
//        return OpenFileService.sendBigFileDownload(appkey, channelNo, fileId, dirPath);
//    }
//
    public static String sendBigFileDownload(String channelNo, String fileId, String dirPath) throws Exception {
        return OpenFileService.sendBigFileDownload(channelNo, fileId, dirPath);
    }

    public static FileDownloadResponse handleFileDowloadRes(String fileId, String dirPath, String res) throws Exception {
        JSONObject resJson = JSONObject.parseObject(res);
        FileDownloadResponse fileDownloadResponse = (FileDownloadResponse) JSONObject.parseObject(JSON.toJSONString(resJson.getJSONObject("Data")), FileDownloadResponse.class);
        if (!"0000".equals(fileDownloadResponse.getRetCode())) {
            return fileDownloadResponse;
        }
        if (dirPath == null) {
            return fileDownloadResponse;
        }
        String originalFilename = fileDownloadResponse.getData().getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.indexOf("."), originalFilename.length());
        File dirFile = new File(dirPath);
        if (dirFile.isFile()) {
            throw new RuntimeException("dirPath必须为目录");
        }
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        String localFilePath = dirPath + File.separator + originalFilename;
        FileUtils.copy(Base64.decode(fileDownloadResponse.getData().getFileBytes()), new File(localFilePath));
        return fileDownloadResponse;
    }
//
    public static String getFileDownloadRequest(String fileId, String channelNo) {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        Map<String, Object> dataMap = new HashMap<String, Object>();
        requestMap.put("Data", dataMap);
        dataMap.put("fileId", fileId);
        dataMap.put("channelNo", channelNo);
        return JSON.toJSONString(requestMap);
    }
//
//    private static void checkFilename(String filename) {
//        if (null == filename || !filename.contains(".")) {
//            throw new IllegalArgumentException("filename 不合法");
//        }
//    }
//
//    private static Map<String, FileUploadRequest> getFileUploadRequest(String channelNo, String filename, byte... bytes) throws Exception {
//        checkFilename(filename);
//        if (channelNo == null || channelNo.trim().length() == 0) {
//            throw new IllegalArgumentException("channelNo 不合法");
//        }
//        if (null == bytes || bytes.length <= 0) {
//            File file = new File(filename);
//            if (!file.exists()) {
//                throw new IllegalArgumentException(String.format("%s 文件不存在", new Object[]{filename}));
//            }
//            bytes = readAllBytes(file);
//            int index = Math.max(filename.lastIndexOf('/'), filename.lastIndexOf('\\'));
//            index = (index >= 0) ? (index + 1) : 0;
//            filename = filename.substring(index);
//        }
//        HashMap<String, FileUploadRequest> map = new HashMap<String, FileUploadRequest>();
//        map.put("Data", FileUploadRequest.builder().bytes(Base64.toBase64String(bytes)).filename(filename).channelNo(channelNo).build());
//        return map;
//    }
//
//    private static byte[] readAllBytes(File file) throws Exception {
//        FileInputStream fileInputStream = new FileInputStream(file);
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        try {
//            byte[] buffer = new byte[1024000];
//            int length;
//            while ((length = fileInputStream.read(buffer)) != -1) {
//                byteArrayOutputStream.write(buffer, 0, length);
//            }
//            byte[] data = byteArrayOutputStream.toByteArray();
//            fileInputStream.close();
//            byteArrayOutputStream.close();
//            return data;
//        } catch (Exception e) {
//            throw new RuntimeException("文件转换成字节数组出错");
//        } finally {
//            fileInputStream.close();
//            byteArrayOutputStream.close();
//        }
//    }
//
//    public static String encryptMessage(String data) throws SDKException {
//        byte[] randomKey = RandomKey.getKey(16);
//        String returnMessage = "";
//        try {
//            byte[] reqJson = CommonSecurityServiceMerchant.encryService(data, randomKey);
//            returnMessage = new String(reqJson, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return returnMessage;
//    }
//
//    public static String decryptMessage(String data) throws Exception {
//        byte[] dataByte = data.getBytes("UTF-8");
//        String respValue = "";
//        respValue = CommonSecurityServiceMerchant.decryService(dataByte);
//        return respValue;
//    }
//
//    public static String encryptMessageForMultiCustomer(String appkey, String data) throws SDKException {
//        byte[] randomKey = RandomKey.getKey(16);
//        String returnMessage = "";
//        try {
//            byte[] reqJson = CommonSecurityServiceMerchant.encryService(appkey, data, randomKey);
//            returnMessage = new String(reqJson, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return returnMessage;
//    }
//
//    public static String decryptMessageForMultiCustomer(String appkey, String data) throws Exception {
//        byte[] dataByte = data.getBytes("UTF-8");
//        String respValue = "";
//        respValue = CommonSecurityServiceMerchant.decryService(appkey, dataByte);
//        return respValue;
//    }
//
//    public static String getVersionInfo() {
//        JSONObject versionInfo = new JSONObject(true);
//        try {
//            String[] updateInfo = Version.UPDATE_INFO;
//            versionInfo.put("SDK版本", "2.1.230630");
//            JSONObject updateInfoObj = new JSONObject(true);
//            for (int i = 0; i < updateInfo.length; i++) {
//                updateInfoObj.put((i + 1) + "", updateInfo[i]);
//            }
//            versionInfo.put("SDK更新内容", updateInfoObj);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return versionInfo.toJSONString();
//    }
//
    public static boolean containsRetCode(String respStr) {
        if (respStr == null || respStr.contains("OPENRetCode")) {
            return true;
        }
        return false;
    }

    public static String objToStr(Object obj) {
        String value = "";
        if (null != obj) {
            return obj.toString();
        }
        return value;
    }


    public static void main(String[] args) {

        String string = "abc123AVS";
        System.out.println(string.toUpperCase());

        //NBCBOpenSDK.init("", "");


    }

}
