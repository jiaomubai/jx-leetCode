package bank.zlbp;

import bank.zlbp.dto.DecrytpResultDTO;
import bank.zlbp.dto.GetInvoiceFilePackageCountDTO;
import bank.zlbp.dto.GetInvoiceFilePackageInfoDTO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mychain.gov.crypto.utils.Pkcs8Utils;
import com.alipay.mychain.gov.sdk.GovDataSDK;
import com.alipay.mychain.gov.sdk.base.*;
import com.alipay.mychain.gov.sdk.facade.enums.EncryptTpyeEnum;
import com.alipay.mychain.gov.sdk.request.SignedRequest;
import com.nuonuo.plate.extracte.BaseExtracte;
import org.apache.http.entity.ContentType;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPrivateKey;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author jiaoxian
 * @name bank.zlbp
 * @date 2023/11/27 10:18
 * @description TODO
 */
public class ZLBP {

    public static final String ALGORITHM = "RSA";

    public static final String SIGN_ALGORITHM = "SHA512withRSA";

    /**
     * 默认种子, 构建RSA密钥对, 生成的密钥对不变
     */
    private static final String DEFAULT_SEED = "0f22507a10bbddd07d8a3082122966e3";

    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;

    /**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 128;

    //企业纳税?识别号
    private static String instCode = "91330424550523551B";  //纳税人识别号
    //企业密码
    private static String password = "QxJTzthgjvz6K1g4";  // 企业密码
    //企业密钥
    private static String privateKeyContent = "-----BEGIN ENCRYPTED PRIVATE KEY-----\n" +
            "MIH6MFUGCSqGSIb3DQEFDTBIMCcGCSqGSIb3DQEFDDAaBBRMoIDdmh1vMG0CgEvw\n" +
            "dzXCbq/RUAICCAAwHQYJYIZIAWUDBAEqBBA/Cv6mGagZEhQWc4p1E1NuBIGg+wCD\n" +
            "4avB5PcOZrsjKGxJOMZ753cJO0phEqViFbLABsvAFb9aVwuGGl+U+j1TSDWZ8hgH\n" +
            "anOg5Pu/7vDveOM0S2RNWLJvfIhM5jfx6ITBSnW7gG3rApu0EvnFwaRXYWiEvmUS\n" +
            "Uk4rQVIurrESr08M01qKw8z99/6plfWLQjaVhElXbW9KKcBILjLQN0wU3oqnq5bN\n" +
            "8vXZhuouigYzgqn6ww==\n" +
            "-----END ENCRYPTED PRIVATE KEY-----";

    public static void main(String[] args) throws Exception {


        // 91330424307466147J   Su2IkjxhUE9Q9lYY
        // 91330424550523551B   QxJTzthgjvz6K1g4
        String json = "{\"requestId\":\"000100002024010416253810022071\",\"nsrsbh\":\"91330424550523551B\",\"jgrq\":\"2021-09-17\",\"gxfbs\":\"2\",\"authorizedNsrsbh\":\"91330424550523551B\"}";
        String password = "QxJTzthgjvz6K1g4";
        String filePath = "D:\\document\\jiaoxian\\电子凭证\\浙里办票\\privateKey";
        String privateKeyContent = readFile(filePath);
        GetInvoiceFilePackageCountDTO getInvoiceFilePackageCount = JSON.parseObject(json, GetInvoiceFilePackageCountDTO.class);
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("authorizedNsrsbh", getInvoiceFilePackageCount.getAuthorizedNsrsbh());
        map.put("gxfbs", getInvoiceFilePackageCount.getGxfbs());
        map.put("jgrq", getInvoiceFilePackageCount.getJgrq());
        map.put("nsrsbh", getInvoiceFilePackageCount.getNsrsbh());
        map.put("requestId", getInvoiceFilePackageCount.getRequestId());
        String jsonStr = JSONObject.toJSONString(map);
        String sign = getSign(jsonStr, getInvoiceFilePackageCount, privateKeyContent, password);
//        System.out.println("sign = " + sign);
        String uri = "http://zlbp.zhejiang.chinatax.gov.cn/api/zww/invoice/file/getInvoiceFilePackageCount";
        String result = JSON.toJSONString(post(sign, uri));
        System.out.println("请求结果为:" + result);

        // 获取版式文件
//        String json = "{\"requestId\":\"000100002023121814431910022070\",\"nsrsbh\":\"91330424307466147J\",\"pageNumber\":1}";
//        String password = "Su2IkjxhUE9Q9lYY";
//        String filePath = "D:\\document\\jiaoxian\\电子凭证\\浙里办票\\key2";
//        String privateKeyContent = readFile(filePath);
//        GetInvoiceFilePackageInfoDTO getInvoiceFilePackageInfo = JSON.parseObject(json, GetInvoiceFilePackageInfoDTO.class);
//        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
//        map.put("nsrsbh", getInvoiceFilePackageInfo.getNsrsbh());
//        map.put("requestId", getInvoiceFilePackageInfo.getRequestId());
//        map.put("pageNumber", getInvoiceFilePackageInfo.getPageNumber());
//        String jsonStr = JSONObject.toJSONString(map);
//        String sign = getSign(jsonStr, getInvoiceFilePackageInfo, privateKeyContent, password);
//        System.out.println("sign = " + sign);
//        String uri = "http://zlbp.zhejiang.chinatax.gov.cn/api/zww/invoice/file/getInvoiceFilePackagesInfo";
//        GenericResult result = post(sign, uri);
//        System.out.println("result:" + result);
//        DecrytpResultDTO decrytpResultDTO = decryptList(result.getData(), "D:/document/jiaoxian/电子凭证/浙里办票/ofd", "91330424307466147J", password, privateKeyContent);
//        System.out.println("genericResult:" + JSON.toJSONString(decrytpResultDTO));
//        byte[] fileContent = (byte[]) decrytpResultDTO.getFileInfoList().get(0).get("fileContent");
//        GenericResult genericResult1 = getOfdToJson2(fileContent);




    }

    public static GenericResult getOfdToJson2(byte[] fileContent) throws FileNotFoundException {
        GenericResult genericResult = new GenericResult();
        List<JSONObject> jsonList = new ArrayList<>();
        try {
            InputStream is = Files.newInputStream(Paths.get(Arrays.toString(fileContent)));
            BaseExtracte baseExtracte = new BaseExtracte();
            JSONObject jsonObject = baseExtracte.readXbrl(is);
            jsonList.add(jsonObject);
            is.close();
            genericResult.setSuccess(true);
            genericResult.setData(String.valueOf(jsonList));
            genericResult.setErrorCode("200");
            genericResult.setErrorMsg("解密完成!共解密成功:"+jsonList.size()+"份.");
            return genericResult;
        }
        catch (IOException e) {
            genericResult.setSuccess(false);
            genericResult.setErrorCode("000001");
            genericResult.setErrorMsg("操作失败");
            return genericResult;
        }
    }

    public static GenericResult getOfdToJson(String fileDirPathSrc){
        GenericResult r=new GenericResult();
        try {
            List<JSONObject> jsonList=new ArrayList<>();
            File file = new File(fileDirPathSrc);
            File[] files = file.listFiles();
            File[] var4 = files;
            int var5 = files.length;
            for(int var6 = 0; var6 < var5; ++var6) {
                File f = var4[var6];
                if (!f.getName().endsWith(".xml")) {
                    InputStream is = new FileInputStream(f);
                    BaseExtracte baseExtracte = new BaseExtracte();
                    JSONObject jsonObject = baseExtracte.readXbrl(is);
                    jsonList.add(jsonObject);
                    is.close();
                }
            }
            r.setSuccess(true); r.setData(String.valueOf(jsonList));r.setErrorCode("200");
            r.setErrorMsg("解密完成!共解密:"+files.length+"份,成功:"+jsonList.size()+"份.");
            return r;
        }
        catch (IOException e) {
            r.setSuccess(false); r.setErrorCode("000001");
            r.setErrorMsg("操作失败");
            return r;
        }
    }

    public static String readFile(String filePath) {
        String privateKeyContent = "";
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            StringBuilder stringBuilder = new StringBuilder();

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
            }
            privateKeyContent = stringBuilder.toString();

            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {

        }
//        System.out.println("密钥信息为:" + privateKeyContent);
        return privateKeyContent;
    }

    public void handleProviders() {
        Provider[] providers = Security.getProviders();
        int size = providers.length;
        for (int i = 0; i < size; i++) {
            String providerName = providers[i].getName();
            Security.removeProvider(providerName);
        }

    }

    public static String getSign(String jsonStr, GetInvoiceFilePackageInfoDTO getInvoiceFilePackageInfo, String privateKeyContent, String password) {
        GovDataSDK.getInstance().init(getInvoiceFilePackageInfo.getNsrsbh(), privateKeyContent, password, EncryptTpyeEnum.SM4);

        SignedRequest request = GovDataSDK.getInstance().getRequestBuilder().generateSignedPayload(jsonStr);
        System.out.println("生成的签名为:" + JSON.toJSONString(request));
        return JSON.toJSONString(request);
    }
    public static String getSign(String jsonStr, GetInvoiceFilePackageCountDTO getInvoiceFilePackageCount, String privateKeyContent, String password) {
        GovDataSDK.getInstance().init(getInvoiceFilePackageCount.getAuthorizedNsrsbh(), privateKeyContent, password, EncryptTpyeEnum.SM4);
        SignedRequest request = GovDataSDK.getInstance().getRequestBuilder().generateSignedPayload(jsonStr);
        System.out.println("生成的签名为:" + JSON.toJSONString(request));
        return JSON.toJSONString(request);
    }

    public static GenericResult post(String jsonStr, String uri) {
        String response = null;
        try {
            response = HttpClientUtils.doPost(uri, jsonStr, ContentType.APPLICATION_JSON);
        } catch (Exception e) {
            e.printStackTrace();
        }
        BaseRestResult baseRestResult = JSON.parseObject(response, BaseRestResult.class);

        GenericResult genericResult = JSON.parseObject(response, GenericResult.class);
//        System.out.println("genericResult:" + JSON.toJSONString(genericResult));
        return genericResult;
    }

    //解析ofd文件下载到本地文件夹
    public static DecrytpResultDTO decryptList(String dataList, String fileDirPathSrc, String nsrsbh, String password, String privateKeyContent) throws IOException {
        List<FileResultZww> fileResultZwwList = JSON.parseArray(dataList, FileResultZww.class);
        System.out.println("fileResultZwwList.size:" + fileResultZwwList.size());
        DecrytpResultDTO decrytpResultDTO = new DecrytpResultDTO();
        List<Map<String, Object>> fileContentList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i< fileResultZwwList.size(); i++) {
            DecryptAndVerifyUtils decryptAndVerifyUtils = new DecryptAndVerifyUtils(nsrsbh, password, privateKeyContent);
            System.out.println("decryptAndVerifyUtils:" + JSON.toJSONString(decryptAndVerifyUtils));
            FileResultZww fileResultZww = fileResultZwwList.get(i);
            System.out.println("fileResultZww:" + JSON.toJSONString(fileResultZww));
            if (fileResultZww != null) {
                Map<String, Object> map = new HashMap<String, Object>();
                String fileName = fileResultZww.getFileName();
                System.out.println("fileName:" + fileName);
                byte[] fileContent = decryptAndVerifyUtils.decryptZww(fileResultZww);

                String filePath = fileDirPathSrc + "/" + fileName;
                DataOutputStream out = new DataOutputStream(Files.newOutputStream(Paths.get(filePath)));
                byte[] b = fileContent;
                for (int j = 0; j < b.length; j++) {
                    out.writeByte(b[j]);
                }
                out.flush();

                map.put("fileName", fileName);
                map.put("fileContent", fileContent);
//                map.put(fileName, fileContent);
                fileContentList.add(map);
            }
        }
        decrytpResultDTO.setSuccess(true);
        decrytpResultDTO.setFileInfoList(fileContentList);
        //decrytpResultDTO.setData(JSON.toJSONString(fileContentList));
        decrytpResultDTO.setErrorCode("200");
        decrytpResultDTO.setErrorMsg("解密下载完成!共解密:" + fileResultZwwList.size() + "份,成功: " + fileContentList.size() + "份.");
        System.out.println("decrytpResultDTO:" + JSON.toJSONString(decrytpResultDTO));
        return decrytpResultDTO;
    }

    public static void readFile() {
        File file = new File("D:\\document\\jiaoxian\\电子凭证\\浙里办票\\privateKey");
            // 创建一个输入流
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        // 读取文件内容
            while (true) {
                int read = 0;
                try {
                    read = inputStream.read();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                // 是否读完
                if (read == -1) {
                    break;
                }
                System.out.println(read);
            }
            // 关闭
        try {
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
