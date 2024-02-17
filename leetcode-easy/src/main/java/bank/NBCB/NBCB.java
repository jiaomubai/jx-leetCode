package bank.NBCB;

import com.nbcb.sdk.OpenSDK;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiaoxian
 * @name bank.NBCB
 * @date 2023/8/17 20:23
 * @description TODO
 */
public class NBCB {

    public void test() throws Exception {

        String filePath = "D:\\document\\jiaoxian\\电票\\宁波银行\\财资系统\\NBCB_ECDS_config.properties";
        String privateKey = "MIGTAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBHkwdwIBAQQgTt6OadouxxxSDg/0SZdOIBqtnFGKrpwmL+quEUf+hfSgCgYIKoEcz1UBgi2hRANCAAQGHNN2NO7btp+w1248yk98E0asGC8sG0bmIzdom4M0xp3vc4IfXjmZ8omUz4oVcjzAuyMSSpJM6uPLcU1SH4HZ";
        String productId = "tmsBill";
        String serviceId = "speedBankBillApply";
        String requestData = "{\"Data\":{\"custId\":\"0000112058\",\"corpCode\":\"1201\",\"apiBatchNo\":\"iaoxian000020233\r\n" +
                "09151108312895233\",\"transAmount\":\"1.00\",\"drawerAccountNumber\":\"78040122000589376\",\"isSignContract\":\"1\",\"pct\":\"0\",\"bailRate\":\"0\",\"depositBondAmt\":\"0.00\",\"payAccountNumber\":null,\"postAddr\":null,\"reciptName\":null,\"position\":null,\"telNo\":null,\"certificateNo\":null,\"faxNo\":null,\"mobNo\":null,\"emailNo\":null,\"draftList\":[{\"apiDtlNo\":\"jiaoxian000020230915110831289250\",\"receiver\":\"728120101\",\"receiverAccountNumber\":\"40010122001356214\",\"receiverAccountName\":\"728120101\",\"receiverIdntCd\":null,\"receiverBankBranchName\":\"宁波银行股份有限公司江北支行\",\"receiverBB\r\n" +
                "ankBranchId\":\"000003039\",\"endDateWay\":\"1\",\"term\":\"6\",\"endDate\":null,\"draftAmount\":\"1.00\",\"isAutoRecvDraft\":\"0\",\"remark\":null,\"exchangeFlag\":\"EM00\",\"isSplit\":\"1\"}],\"fileInfoList\":[]}}";

        NBCBOpenSDK.init(filePath, privateKey);
        //OpenSDK.init(filePath, privateKey);
        String responseData = NBCBOpenSDK.send(productId, serviceId, requestData);
        System.out.println("responseData:" + responseData);
    }

    public static void main(String[] args) throws Exception {

        String string = "<?xml version=\"1.0\" encoding=\"utf-8\"?><soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><soap:Body><ZFZTCXReturnResponse xmlns=\"http://tempuri.org/\"><ZFZTCXReturnResult>{\"ZJFK\": [{\"SignIn\":\"SignIn\",\"BankAccount \":\"13001629308050503085\",\"RefBillCode\":\"121340020230925161325315000589\",\"BillID\":\"121340020230925161325315000589\",\"FKZT\":\"1\",\"MESSAGE\":\"查询支付状态成功;建行CMP报文发送银行错误！索引超出了数组界限。\n" +
                "   在 LCBIP.Banks.CCB.Bank_CCB_CMP.Bank_CCB_Send(String&amp; retCode, String&amp; errMsg)|成功结束\"}]}</ZFZTCXReturnResult></ZFZTCXReturnResponse></soap:Body></soap:Envelope>\n";
        System.out.println(string);
        System.out.println(string.replaceAll("\n", ""));
        System.out.println();

//
//        String str = "0000000123045";
//        int result = Integer.parseInt(str);
//        String temp= String.valueOf(result);
//        System.out.println(temp);
//
//        BigDecimal bigDecimal = new BigDecimal("0.1");
//        BigDecimal bigDecimal1 = new BigDecimal("0.2");
//        BigDecimal bigDecimal2 = new BigDecimal("0.1");
//        System.out.println(bigDecimal.compareTo(bigDecimal1));
//        System.out.println(bigDecimal.compareTo(bigDecimal2));
//
//        String prefix = "000000000000";
//        String billRangeStartNew = prefix + "12345";
//        if (billRangeStartNew.length() > 12) {
//            System.out.println(billRangeStartNew.substring(billRangeStartNew.length() - 12));
//        }
//        System.out.println();



//        new NBCB().test();
//        Map<String, String> map = new HashMap<>();
//        map.size();
    }

}
