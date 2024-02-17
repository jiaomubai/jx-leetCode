//package bank;
//
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.bob.opk.bobsdk.BobsdkService;
//import com.bob.opk.bobsdk.KeyStoreFactory;
//import com.bob.opk.bobsdk.config.BobsdkProperties;
//import com.bob.sdk.bean.AbstractBussinessBean;
//import com.dc.sdk.bean.OPBJCNCN0208100008800001;
//import com.dc.sdk.bean.Ret;
////import org.springframework.beans.BeanUtils;
//
//import javax.crypto.Cipher;
//import javax.crypto.spec.SecretKeySpec;
//import java.io.BufferedReader;
//import java.io.File;
//import java.net.URLDecoder;
//import java.net.URLEncoder;
//import java.sql.Timestamp;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.*;
//import java.util.List;
//
///**
// * @author jiaoxian
// * @name bank
// * @date 2023/3/27 11:17
// * @description TODO
// */
//public class ChannelBank {
//
//    /*
//    private static final String ALGORITHM = "AES/ECB/PKCS5Padding";
//
//
//    private String getSign() {
//
//        return "";
//
//    }
//
//    private String decrypt(String encryptData, String decryptKey) {
//        String decryptData = "";
//        try {
//            Cipher cipher = Cipher.getInstance(ALGORITHM);
//            SecretKeySpec secretKeySpec = new SecretKeySpec(decryptKey.getBytes(), "AES");
//            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
//            decryptData = new String(cipher.doFinal(Base64.getDecoder().decode(encryptData)));
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return decryptData;
//    }
//
//    public String encrypt(String strToEncrypt, String secret) {
//        try {
//            SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), "AES");
//            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
//            return Base64.getEncoder()
//                    .encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
//        } catch (Exception e) {
//            System.out.println("Error while encrypting: " + e.toString());
//        }
//        return null;
//    }
//
//
//*/
//
//    public void test() throws Exception {
//        OPBJCNCN0208100008800001 isRecharge = new OPBJCNCN0208100008800001();
//        OPBJCNCN0208100008800001.Request request = (OPBJCNCN0208100008800001.Request) isRecharge.getReq();
//        String jsonData = "{\"opName\":\"CebankUserLogonOp\",\"serialNo\":\"091525272090001\",\"reqTime\":\"20230509\",\"userID\":\"Cloud\",\"userPWD\":\"000000\",\"certNumber\":\"\"}";
//        BeanUtils.copyProperties(JSON.parseObject(jsonData, OPBJCNCN0208100008800001.Request.class), request);
//        String configPath = "{\"appId\":\"04397684\",\"appPublicKey\":\"MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAEVVawFD6Jeei9pkagK9EoAdVVXouMU0jDfHXgufNyvq/b0vrx8yKUM/aBjiaBaRvxDkPIvhSZB/Kk3I+L7TxOOA==\",\"merchantPrivateKey\":\"MIGTAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBHkwdwIBAQQgVB/pdJksipv+I1KwxxYF7rP3XlF6kUaFUOIS7eGAU26gCgYIKoEcz1UBgi2hRANCAATCGNJiNyY9vpTxuO1TRhlKiG++hBpxlQmESbFc7TR/owEsnadDJxT9L/rb9Z0XtY0IWq6G0c/5r6oaiB3Yk/uz\",\"publicKey\":\"MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAECR/MKP+VcMme5P5/zmwJCQoiDej9/uMV02ggeSxNXBlFYMdXSEACoApzOO4Rm+Ny80rwO0lhpfHmIsN/h1vOag==\",\"keyStringA1\":\"Bjta7+fLnUvWaBKsoGYf3A==\",\"keyStringA2\":\"wkOkQ9Ubax5X4AqkE9jWVA==\",\"publicUrl\":\"http://219.237.75.79:17721\",\"opencaname\":\"openbank.cer\",\"encryType\":\"01\",\"signType\":\"04\",\"paySalaryNo\":\"10050087\",\"userPWD\":\"000000\",\"userID\":\"Cloud\",\"productId\":\"04393407\",\"caTopic\":\"C=CN,O=BankofBeiJing,OU=BankofBeiJing,CN=BankofBeiJing\",\"caPawd\":null,\"caName\":\"cert2_cb.pfx\",\"opencadir\":\"D:\\\\document\\\\jiaoxian\\\\����\\\\D20742\",\"caPrefix\":\"D:\\\\document\\\\jiaoxian\\\\����\\\\D20742\"}";
//        Map<String, String> propertiesDataMap = (Map) JSON.parse(configPath);
//        BobsdkProperties bobsdkProperties = getProperties(propertiesDataMap);
//        BobsdkService bobsdkService = new BobsdkService(bobsdkProperties);
//        bobsdkService.sendPool(bobsdkProperties, (AbstractBussinessBean) isRecharge);
//        String result = JSONObject.toJSONString(isRecharge.getResp());
//        System.out.println(result);
//        KeyStoreFactory.getInstance().getOpenAPPPublicKey();
//
//
//    }
//
//    public static BobsdkProperties getProperties(Map<String, String> prop) {
//
//        BobsdkProperties bobsdkProperties = new BobsdkProperties();
//
//        bobsdkProperties.setAppId(prop.get("appId"));
//        // Ӧ�ñ��(���������ṩ)
//        bobsdkProperties.setAppPublicKey(prop.get("appPublicKey"));
//        // ƽ̨-Ӧ�ù�Կ(���������ṩ)
//        bobsdkProperties.setMerchantPrivateKey(prop.get("merchantPrivateKey"));
//        // ˽Կ(���������ṩ)
//        bobsdkProperties.setPublicKey(prop.get("publicKey"));
//        // ƽ̨��Կ(���������ṩ)
//        bobsdkProperties.setKeyStringA1(prop.get("keyStringA1"));
//        // A1 ����Կ(���������ṩ)
//        bobsdkProperties.setKeyStringA2(prop.get("keyStringA2"));
//        // A2 ����Կ(���������ṩ)
//        bobsdkProperties.setPublicUrl(prop.get("publicUrl"));
//        // ���ʿ���ƽ̨��ַ(���������ṩ)
//        bobsdkProperties.setOpencadir(prop.get("opencadir"));
//        // ��Կ֤��Ŀ¼(֤���ļ����·��)
//        bobsdkProperties.setOpencaname(prop.get("opencaname"));
//        // ��Կ֤������(���������ṩ)
//        bobsdkProperties.setEncryType(prop.get("encryType"));
//        // ��������(���������ṩ)
//        bobsdkProperties.setSignType(prop.get("signType"));
//        // ��ǩ����(���������ṩ)
//        bobsdkProperties.setReadTimeout(50000);
//        // ��ȡ��Ӧ�ĳ�ʱʱ��
//        bobsdkProperties.setConnectTimeout(10000);
//        // �������ӵĳ�ʱʱ��
//        bobsdkProperties.setUseProxy(false);// �Ƿ�������
//        // https �Ĵ����ַ������������ʹ��Ĭ��ֵ���ɣ�
//        bobsdkProperties.setHttpsProxyHost("127.0.0.1");
//        bobsdkProperties.setHttpsProxyport(0);
//        // https �Ĵ���˿ڣ�����������ʹ��Ĭ��ֵ��
//        // http �Ĵ����ַ������������ʹ��Ĭ��ֵ���ɣ�
//        bobsdkProperties.setHttpProxyHost("127.0.0.1");
//        bobsdkProperties.setHttpProxyport(0);
//        bobsdkProperties.setProductId(prop.get("productId"));
//        bobsdkProperties.setCaPrefix(prop.get("caPrefix"));
//        bobsdkProperties.setCaTopic(prop.get("caTopic"));
//        bobsdkProperties.setCaPawd(prop.get("caPawd"));
//        bobsdkProperties.setCaName(prop.get("caName"));
//        return bobsdkProperties;
//    }
//
//
//    public static void main(String[] args) throws Exception {
//
//        ChannelBank channelBank = new ChannelBank();
//        channelBank.testJson();
//
//    }
//
//    public void testJson() {
//
//        AlibabaAscpUopConsignorderNotifyRequest req = new AlibabaAscpUopConsignorderNotifyRequest();
//        AlibabaAscpUopConsignorderNotifyRequest.Request obj1 = new AlibabaAscpUopConsignorderNotifyRequest.Request();
//        AlibabaAscpUopConsignorderNotifyRequest.OrderItems obj2 = new AlibabaAscpUopConsignorderNotifyRequest.OrderItems();
//        AlibabaAscpUopConsignorderNotifyRequest.OrderItem obj5 = new AlibabaAscpUopConsignorderNotifyRequest.OrderItem();
//        AlibabaAscpUopConsignorderNotifyRequest.ReceiverInfo obj6 = new AlibabaAscpUopConsignorderNotifyRequest.ReceiverInfo();
//        AlibabaAscpUopConsignorderNotifyRequest.SenderInfo obj7 = new AlibabaAscpUopConsignorderNotifyRequest.SenderInfo();
//        AlibabaAscpUopConsignorderNotifyRequest.DeliverRequirement obj8 = new AlibabaAscpUopConsignorderNotifyRequest.DeliverRequirement();
//
//        List<AlibabaAscpUopConsignorderNotifyRequest.OrderItem> list4 = new ArrayList<AlibabaAscpUopConsignorderNotifyRequest.OrderItem>();
//
//        obj1.setSupplierId("1111222");
//        obj1.setSupplierName("��Ӧ������");
//        obj1.setOrderSource("201");
//        obj1.setBizOrderCode("scp0001");
//        System.out.println(JSONObject.toJSONString(obj1));
//        obj5.setSubOrderCode("11111");
//        obj5.setScItemId("1111");
//        obj5.setOuterId("��Ʒ�̼ұ���");
//        obj5.setBarCode("��Ʒ������");
//        obj5.setQuantity(1L);
//        obj5.setScItemName("��Ʒ����");
//        obj5.setTradeOrerId("11111");
//        obj5.setSubTradeOrderId("2222");
//        obj5.setItemAmount(1200L);
//        obj5.setScItemSpecification("Ĭ��");
//        obj5.setTcOrderId("11111");
//        obj5.setTcSubOrderId("11111");
//        list4.add(obj5);
//        obj2.setOrderItem(list4);
//        obj1.setOrderItems(obj2);
//        obj1.setStoreCode("�����ֱ���");
//        obj1.setStoreName("����������");
//        obj6.setReceiverZipCode("839333");
//        obj6.setReceiverCountry("�й�");
//        obj6.setReceiverProvince("�㽭");
//        obj6.setReceiverCity("����");
//        obj6.setReceiverArea("�ຼ");
//        obj6.setReceiveTown("�峣");
//        obj6.setReceiverAddress("��һ��·969��");
//        obj6.setReceiverName("�ռ�������");
//        obj6.setReceiverMobile("13828020288");
//        obj6.setReceiverPhone("0571-38338988");
//        obj6.setAid("LGMKeXaRpNeiahiaeSY5Gc0u31R6dcm5Gp5owD8gibW518ltkm1qeueSn7l0HdMQ4RSpjAXLXX");
//        obj6.setReceiverSecurityMobile("13828020288ת1234");
//        obj6.setPrivacy("1");
//        obj6.setLon("121.507261");
//        obj6.setLat("31.233882");
//        obj6.setOaidSourceCode("213456");
//        obj1.setReceiverInfo(obj6);
//        obj7.setSenderZipCode("839333");
//        obj7.setSenderCountry("�й�");
//        obj7.setSenderProvince("�Ĵ�");
//        obj7.setSenderCity("�ɶ�");
//        obj7.setSenderArea("��ţ");
//        obj7.setSenderTown("����");
//        obj7.setSenderAddress("�ľ���·969��");
//        obj7.setSenderName("����");
//        obj7.setSenderMobile("13800282091");
//        obj7.setSenderPhone("028-89288292");
//        obj1.setSenderInfo(obj7);
//        obj8.setAppointDeliveryTime("2014-01-14 12:20:00");
//        obj8.setAppointArrivedTime("2014-01-14 12:20:00");
//        obj1.setDeliverRequirement(obj8);
//        obj1.setTmsServiceName("��ͨ");
//        obj1.setPostMode("����");
//        obj1.setPostFee(0L);
//        obj1.setOrderCreateTime("2014-01-14 12:20:00");
//        obj1.setExtraContent("xx:xx;xx:xx");
//        obj1.setItemsValue(3900L);
//        obj1.setKlTradeId("202104081459");
//        obj1.setBuyerMessage("�뾡�췢��");
//        obj1.setSellerId("1111");
//        obj1.setSellerNick("���Ե���1");
//        obj1.setBizType("10000");
//        obj1.setTransWareHouseCode("TRAN_STORE_1111");
//        obj1.setTransWareHouseAddress("��һ��·969��");
//        obj1.setSrcLgOrderCode("LPXXXX");
//        obj1.setBusinessModel("0");
//        obj1.setSaleOwner("2222");
//        obj1.setSourcePlatformCode("TMGJZY");
//        obj1.setEsDate("2022-01-01 00:00:00");
//        obj1.setDeliveryTime("2022-01-01");
//        obj1.setOrderType("BFCK");
//        obj1.setSourceConsignLp("LP00511469954979");
//        obj1.setPlaceOrderTime("2022-01-01 00:00:00");
//        obj1.setPayTime("2022-01-01 00:00:00");
//
//        req.setRequest(obj1);
//        req.setCustomerId("11111");
//
//        System.out.println(JSON.toJSONString(req));
//
//
//    }
//
//    private static void userApplicationOperateFirst() throws Exception {
////		BobsdkProperties bobsdkProperties = new BobsdkProperties();
////		bobsdkProperties.setAppId("04397684");
////		bobsdkProperties.setAppPublicKey(
////				"MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAEVVawFD6Jeei9pkagK9EoAdVVXouMU0jDfHXgufNyvq/b0vrx8yKUM/aBjiaBaRvxDkPIvhSZB/Kk3I+L7TxOOA==");
////		bobsdkProperties.setMerchantPrivateKey(
////				"MIGTAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBHkwdwIBAQQgVB/pdJksipv+I1KwxxYF7rP3XlF6kUaFUOIS7eGAU26gCgYIKoEcz1UBgi2hRANCAATCGNJiNyY9vpTxuO1TRhlKiG++hBpxlQmESbFc7TR/owEsnadDJxT9L/rb9Z0XtY0IWq6G0c/5r6oaiB3Yk/uz");
////		bobsdkProperties.setPublicKey(
////				"MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAECR/MKP+VcMme5P5/zmwJCQoiDej9/uMV02ggeSxNXBlFYMdXSEACoApzOO4Rm+Ny80rwO0lhpfHmIsN/h1vOag==");
////		bobsdkProperties.setKeyStringA1("Bjta7+fLnUvWaBKsoGYf3A==");
////		bobsdkProperties.setKeyStringA2("wkOkQ9Ubax5X4AqkE9jWVA==");
////		bobsdkProperties.setPublicUrl("http://219.237.75.79:17721");
////		bobsdkProperties.setOpencadir("D:\\document\\jiaoxian\\����\\D20742");
////		bobsdkProperties.setOpencaname("openbank.cer");
////		bobsdkProperties.setEncryType("01");
////		bobsdkProperties.setSignType("04");
////		bobsdkProperties.setReadTimeout(50000);
////		bobsdkProperties.setConnectTimeout(10000);
////		bobsdkProperties.setUseProxy(false);
////		bobsdkProperties.setHttpsProxyHost("127.0.0.1");
////		bobsdkProperties.setHttpsProxyport(0);
////		bobsdkProperties.setHttpProxyHost("127.0.0.1");
////		bobsdkProperties.setHttpProxyport(0);
////		bobsdkProperties.setProductId("04393407");
////		bobsdkProperties.setCaPrefix("D:\\document\\jiaoxian\\����\\D20742");
////		bobsdkProperties.setCaTopic("C=CN,O=BankofBeiJing,OU=BankofBeiJing,CN=BankofBeiJing");
////		bobsdkProperties.setCaPawd("");
////		bobsdkProperties.setCaName("cert2_cb.pfx");
//
//        OPBJCNCN0208100008800001 isRecharge = new OPBJCNCN0208100008800001();
//        OPBJCNCN0208100008800001.Request request = (OPBJCNCN0208100008800001.Request) isRecharge.getReq();
//        String jsonData = "{\"opName\":\"CebankUserLogonOp\",\"serialNo\":\"091525272090001\",\"reqTime\":\"20230509\",\"userID\":\"Cloud\",\"userPWD\":\"000000\",\"certNumber\":\"\"}";
//        BeanUtils.copyProperties(JSON.parseObject(jsonData, OPBJCNCN0208100008800001.Request.class), request);
//        String configPath = "{\"appId\":\"04397684\",\"appPublicKey\":\"MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAEVVawFD6Jeei9pkagK9EoAdVVXouMU0jDfHXgufNyvq/b0vrx8yKUM/aBjiaBaRvxDkPIvhSZB/Kk3I+L7TxOOA==\",\"merchantPrivateKey\":\"MIGTAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBHkwdwIBAQQgVB/pdJksipv+I1KwxxYF7rP3XlF6kUaFUOIS7eGAU26gCgYIKoEcz1UBgi2hRANCAATCGNJiNyY9vpTxuO1TRhlKiG++hBpxlQmESbFc7TR/owEsnadDJxT9L/rb9Z0XtY0IWq6G0c/5r6oaiB3Yk/uz\",\"publicKey\":\"MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAECR/MKP+VcMme5P5/zmwJCQoiDej9/uMV02ggeSxNXBlFYMdXSEACoApzOO4Rm+Ny80rwO0lhpfHmIsN/h1vOag==\",\"keyStringA1\":\"Bjta7+fLnUvWaBKsoGYf3A==\",\"keyStringA2\":\"wkOkQ9Ubax5X4AqkE9jWVA==\",\"publicUrl\":\"http://219.237.75.79:17721\",\"opencaname\":\"openbank.cer\",\"encryType\":\"01\",\"signType\":\"04\",\"paySalaryNo\":\"10050087\",\"userPWD\":\"000000\",\"userID\":\"Cloud\",\"productId\":\"04393407\",\"caTopic\":\"C=CN,O=BankofBeiJing,OU=BankofBeiJing,CN=BankofBeiJing\",\"caPawd\":null,\"caName\":\"cert2_cb.pfx\",\"opencadir\":\"D:\\\\document\\\\jiaoxian\\\\����\\\\D20742\",\"caPrefix\":\"D:\\\\document\\\\jiaoxian\\\\����\\\\D20742\"}";
//        Map<String, String> propertiesDataMap = (Map<String, String>) JSON.parse(configPath);
//        BobsdkProperties bobsdkProperties = getProperties(propertiesDataMap);
//        BobsdkService bobsdkService = new BobsdkService(bobsdkProperties);
////		OPBJCNCN0208100008800001 isRecharge = new OPBJCNCN0208100008800001();
////		OPBJCNCN0208100008800001.Request request = (OPBJCNCN0208100008800001.Request) isRecharge.getReq();
////		TestRequest testRequest = new TestRequest();
////		testRequest.setReqTime("20210917");
////		testRequest.setSerialNo("20210903113413");
////		testRequest.setUserID("Cloud");
////		testRequest.setUserPWD("000000");
////		BeanUtils.copyProperties(testRequest, request);
//        System.out.println("������:\r\n" + JSON.toJSONString(isRecharge));
//        bobsdkService.sendPool(bobsdkProperties, (AbstractBussinessBean) isRecharge);
//        OPBJCNCN0208100008800001.Response response = (OPBJCNCN0208100008800001.Response) isRecharge.getResp();
//        System.out.println("��Ӧ����1��" + response.getResultCode() + ":" + response.getResultMessage());
//        System.out.println("Ӧ��1��Ӧ����2��" + ((Ret) response.getRet().get(0)).getRetCode() + ":"
//                + ((Ret) response.getRet().get(0)).getRetMsg());
//    }
//
//
//}