//package bank.crcb;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.parser.ParserConfig;
//import com.alibaba.fastjson.util.TypeUtils;
//import com.open.common.ResponseBean;
//import com.open.common.SDKRequestHead;
//import com.open.common.exception.SDKException;
//import com.open.common.exception.SDKExceptionEnums;
//import com.open.common.exception.TokenInvalidException;
//import com.open.common.utils.FileUtils;
//import com.open.common.utils.SecurityUtils;
//import com.open.sdk.OpenSDK;
//import com.open.sdk.aes.param.ConfigFile;
//import com.open.sdk.aes.param.KeyStoreFactory;
//import com.open.sdk.aes.service.*;
//import com.open.sdk.aes.utils.GJUtils;
//import com.open.sdk.aes.utils.GMUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.InputStream;
//import java.nio.charset.StandardCharsets;
//import java.util.Map;
//
///**
// * @author jiaoxian
// * @name bank.crcb
// * @date 2023/8/7 17:06
// * @description TODO
// */
//public class OpenSdkCRCB {
//
//    private static Logger log = LoggerFactory.getLogger(OpenSDK.class);
//
//    public OpenSdkCRCB() {
//    }
//
//    public static boolean init(InputStream is, String privatekey) {
////        Class<OpenSdkCRCB> openSdkCRCBClass = OpenSdkCRCB.class;
//        synchronized(OpenSdkCRCB.class) {
//                try {
//                    ConfigFile.readConfig(is);
//                    String keyPath = ConfigFile.KEYPATH;
//                    if (null != keyPath && !"".equals(keyPath)) {
//                        FileUtils.isExist(keyPath);
//                    }
//
//                    String caPath = ConfigFile.CAPATH;
//                    if (null != caPath && !"".equals(caPath)) {
//                        FileUtils.isExist(caPath);
//                    }
//
//                    ConfigFile.PRIVATEKEY = privatekey;
//                    KeyStoreFactory.getInstance();
//                    if (ConfigFile.GJ) {
//                        KeyStoreFactory.getInstance().setBusinessPrivatekey(GJUtils.parse2PrivateKey(privatekey));
//                        KeyStoreFactory.getInstance().setOpenPublickey(GJUtils.parse2PublicKey(ConfigFile.PUBLICKEY));
//                    } else {
//                        KeyStoreFactory.getInstance().setBusinessPrivatekey(GMUtils.parse2PrivateKey(privatekey));
//                        KeyStoreFactory.getInstance().setOpenPublickey(GMUtils.parse2PublicKey(ConfigFile.PUBLICKEY));
//                    }
//                    log.info("KeyStoreFactory.BusinessPrivatekey:" + JSON.toJSONString(KeyStoreFactory.getInstance().getBusinessPrivatekey()));
//                    log.info("KeyStoreFactory.OpenPublickey:" + JSON.toJSONString(KeyStoreFactory.getInstance().getOpenPublickey()));
//
//                    TypeUtils.compatibleWithJavaBean = true;
//                } catch (Exception exception) {
//                    if (log.isErrorEnabled()) {
//                        log.error("初始化失败", exception);
//                    }
//                    return false;
//                }
//                log.info("初始化成功...");
//            }
//
//        return true;
//    }
//
//    public static ResponseBean send(String productID, String serviceID, String json) throws Exception {
//        ParserConfig.getGlobalInstance().setAsmEnable(false);
//
//        try {
//            Map<String, Object> tokenMap = handleToken();
//            byte[] cntrKey = (byte[])((byte[])tokenMap.get("CntrKey"));
//            byte[] syncKey = (byte[])((byte[])tokenMap.get("SyncKey"));
//            String randomKeyStr = SecurityUtils.getRandomKey();
//            if (log.isDebugEnabled()) {
//                log.debug("random key {}", randomKeyStr);
//            }
//
//            byte[] randomKey = randomKeyStr.getBytes();
//            SDKRequestHead head = PackHeadService.packReqHeadByJson(productID, json);
//            String reqJson = CommonSecurityService.encryService(json, randomKey, cntrKey, syncKey);
//            String url;
//            if (productID != null && !"".equals(productID)) {
//                url = productID + "/" + serviceID;
//            } else {
//                url = "open/" + serviceID;
//            }
//
//            Map<String, Object> resps = BussinessAdapterService.post(url, reqJson.getBytes(StandardCharsets.UTF_8), head);
//            String respStr = handleResponse(resps, randomKey, cntrKey);
//            JSONObject obj = JSON.parseObject(respStr);
//            ResponseBean bean = new ResponseBean();
//            bean.setRqsNo(obj.getJSONObject("Head").getString("RqsNo"));
//            bean.setRspCd(obj.getJSONObject("Head").getString("RspCd"));
//            bean.setRspInf(obj.getJSONObject("Head").getString("RspInf"));
//            bean.setRspDt(obj.getJSONObject("Head").getString("RspDt"));
//            bean.setRspTm(obj.getJSONObject("Head").getString("RspTm"));
//            bean.setData(obj.getString("Data"));
//            return bean;
//        } catch (Exception var15) {
//            log.error("SDK发生异常", var15);
//            throw var15;
//        }
//    }
//
//    private static String handleResponse(Map<String, Object> resps, byte[] randomKey, byte[] cntrKey) throws Exception {
//        if (resps != null && resps.size() != 0) {
//            if (resps.get("token_invalid") != null && "1".equalsIgnoreCase(resps.get("token_invalid").toString())) {
//                ApproveDevService.refreshToken(true);
//                throw new TokenInvalidException();
//            } else {
//                String respValue = "";
//                byte[] resp = (byte[])((byte[])resps.get("resp"));
//                if (resps.get("data_encrypted") != null && !"0".equalsIgnoreCase(resps.get("data_encrypted").toString())) {
//                    respValue = CommonSecurityService.decryService(resp, randomKey, cntrKey);
//                } else if (resp != null) {
//                    respValue = new String(resp);
//                }
//
//                return respValue;
//            }
//        } else {
//            throw new SDKException(SDKExceptionEnums.HTTPCONN_ERROR);
//        }
//    }
//
//    private static Map<String, Object> handleToken() throws SDKException {
//        Map<String, Object> tokenMap = KeyStoreFactory.getInstance().getTokenMap();
//        if (ApproveDevService.tokenInValid(tokenMap)) {
//            int n = ApproveDevService.refreshToken(true);
//            if (n != 0) {
//                throw new SDKException(SDKExceptionEnums.APPROVEDEV_FAIL);
//            }
//
//            tokenMap = KeyStoreFactory.getInstance().getTokenMap();
//            if (ApproveDevService.tokenInValid(tokenMap)) {
//                throw new SDKException(SDKExceptionEnums.APPROVEDEV_FAIL);
//            }
//        }
//
//        return tokenMap;
//    }
//
//}
