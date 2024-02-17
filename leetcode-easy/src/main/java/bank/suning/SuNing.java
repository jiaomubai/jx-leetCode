//package bank.suning;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.TypeReference;
//import com.suning.api.DefaultSuningClient;
//import com.suning.api.SelectSuningResponse;
//import com.suning.api.entity.custom.*;
//import com.suning.api.entity.item.ProductQueryRequest;
//import com.suning.api.exception.SuningApiException;
//import com.vidian.open.sdk.security.OpenSecurityClient;
//import org.apache.http.NameValuePair;
//
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//import okhttp3.MediaType;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.RequestBody;
//import okhttp3.Response;
//
///**
// * @author jiaoxian
// * @name bank.suning
// * @date 2023/5/22 11:15
// * @description TODO
// */
//public class SuNing {
//
//    private static final String[] hexDigits = new String[] {
//            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
//            "a", "b", "c", "d", "e", "f" };
//
//    public static void main(String[] args) {
//
//        String encryptData = "{\"street\":\"33EIS7kBeenvqfoE74YG7lFAcogn3BQ2V7m1pxxNnqxNCGO0Ytp+rtBpi+hYuyOuSw+PEEVZUZIeGfIouazNbQ==\",\"name\":\"MPpxn9gbIhwfCt6igD+btxO6FTVUi/pP/38gvQTu+4o=\",\"address\":\"N5zV2SOKMIHVl7lcMmJR7vcH3ixebYqBrSIOlHyuayDhUChP6Pbg7HvMFxdSIEAqhebFWNR2aQF2O9bk+1cRvw==\",\"idCardNo\":\"C4q6Es1FjoCJhd+HE6jgur1XVPUCS+iZ/iSAeXoNt50=\",\"phone\":\"DDte7/ZZv0dlbHYaLYTX8X/9Ws4C4oYUQOjOebHHJxI=\"}";
//        Map<String, String> encryptMap = new HashMap<String, String>();
//        if (encryptData != null && encryptData != "") {
//            encryptMap = JSON.parseObject(encryptData, new TypeReference<HashMap<String, String>>() {});
//        }
//
//        // Map 转 List
//        List<String> encryptList = new ArrayList<String>();
//        for (Map.Entry<String, String> entry : encryptMap.entrySet()) {
//            if (entry.getValue() != null && !"".equals(entry.getValue())) {
//                encryptList.add(entry.getValue());
//            }
//        }
//        StringBuilder decryptData = new StringBuilder("{");
//        try {
//            OpenSecurityClient client = new OpenSecurityClient("3703031257", "7e4bb67cd815c51182e75719bbc4200f");
//            Map<String, String> decryptDataMap =client.decryptBatch("3703031257", encryptList);
//            String result = client.decrypt("3703031257", "33EIS7kBeenvqfoE74YG7lFAcogn3BQ2V7m1pxxNnqxNCGO0Ytp+rtBpi+hYuyOuSw+PEEVZUZIeGfIouazNbQ==");
//            if (decryptDataMap != null && decryptDataMap.size() > 0) {
//                for (Map.Entry<String, String> entry1 : decryptDataMap.entrySet()) {
//                    String decryptKey = entry1.getKey();
//                    String decryptValue = entry1.getValue();
//                    for (Map.Entry<String, String> entry2 : encryptMap.entrySet()) {
//                        String encryptKey = entry2.getKey();
//                        String encryptValue = entry2.getValue();
//                        if (decryptKey.equals(encryptValue)) {
//                            decryptData.append("\"");
//                            decryptData.append(encryptKey);
//                            decryptData.append("\":\"");
//                            decryptData.append(decryptValue);
//                            decryptData.append("\",");
//                        }
//                    }
//                }
//            }
//            decryptData = new StringBuilder(decryptData.substring(0, decryptData.length() - 1));
//            decryptData.append("}");
//            System.out.println(decryptData);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        System.out.println();
//
//    }
//
//    private static String getSign(String signStr) {
//        String encode = null;
//        try {
//            MessageDigest md = MessageDigest.getInstance("MD5");
//            encode = byteArrayToHexString(md.digest(signStr.getBytes()));
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        return encode;
//
//
//    }
//
//    private static String byteArrayToHexString(byte[] byteArr) {
//
//        StringBuffer sb = new StringBuffer();
//        for (byte b : byteArr) {
//            sb.append(byteToHexString(b));
//        }
//        return sb.toString();
//    }
//
//    private static String byteToHexString(byte digest) {
//        int n = digest;
//        if (n < 0) {
//            n = 256 + n;
//        }
//        return hexDigits[n / 16] + hexDigits[n % 16];
//
//
//    }
//
//
//}
