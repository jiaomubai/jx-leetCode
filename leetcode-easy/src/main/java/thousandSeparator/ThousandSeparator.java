package thousandSeparator;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author jiaoxian
 * @name thousandSeparator
 * @date 2023/6/2 17:30
 * @description leetCode-1556: 千位分隔数
 */
public class ThousandSeparator {

    public String thousandSeparator(int n) {
        StringBuilder result = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder().append(n);
        if (stringBuilder.length() > 3) {
            String str = stringBuilder.reverse().toString();
            for (int i = 0; i < str.length(); i++) {
                if (i % 3 == 2) {
                    result.append(str.charAt(i));
                    result.append(".");
                } else {
                    result.append(str.charAt(i));
                }
            }
            String resultNew = result.reverse().toString();
            if (resultNew.startsWith(".")) {
                return resultNew.substring(1);
            }
            return resultNew;
        } else {
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        Date dt = new Date();
        SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate =  matter1.format(dt);
        System.out.println(nowDate);
        int n = 123456789;
        //System.out.println(new ThousandSeparator().thousandSeparator(n));

        /*
        String sourceString = "REFNBR=H00100202306020000565913930000 ;RPYNAM=刘嘉琳手机盾测试 ;NARYUR=转账 ;TRSBLV=99949999.99 ;RPYACC=898010100100133272 ;ETYTIM=12:49:43 ;ETYDAT=2023-06-02 ;RPYBNK=哈密市商业银行 ;TSDAMT=25000.00 ;TSCAMT=0.00 ;RPYBBN=08101\n" +
                "REFNBR=H00100202306020000565906760000 ;RPYNAM=乌鲁木齐交通旅游投资（集团）有限公司 ;NARYUR=转账 ;TRSBLV=99974999.99 ;RPYACC=898010100100154708 ;ETYTIM=12:48:40 ;ETYDAT=2023-06-02 ;RPYBNK=哈密市商业银行 ;TSDAMT=25000.00 ;TSCAMT=0.00 ;RPYBBN=08101\n" +
                "REFNBR=H00100202306020000565906620000 ;RPYNAM=张燕 ;NARYUR=转账 ;TRSBLV=99999999.99 ;RPYACC=6235668989300004754 ;ETYTIM=12:43:06 ;ETYDAT=2023-06-02 ;RPYBNK=哈密商行乌分行南湖北路支行 ;TSDAMT=0.00 ;TSCAMT=99999999.99 ;RPYBBN=89802";
        String[] strArray1 = sourceString.split("\n");
        List<Map<String, String>> dataList = new ArrayList<>();
        System.out.println(strArray1.length);
        for (int i = 0; i < strArray1.length; i++) {
            String[] strArray2 = strArray1[i].split(";");
            Map<String, String> mapData = new HashMap<>();
            System.out.println(i + " " + strArray2.length);
            for (int j = 0; j < strArray2.length; j++) {
                String[] strArray3 = strArray2[j].split("=");
                System.out.println(i + " " + j + " " +strArray3.length);
                if (strArray3.length == 2) {
                    mapData.put(strArray3[0], strArray3[1].trim());
                } else if (strArray3.length == 1) {
                    mapData.put(strArray3[0], "");
                }
            }
            dataList.add(mapData);
        }
        System.out.println("dataList的大小为:" + dataList.size());

        */

        String price = "0.02";
        String num = "1";
        String totalFee = new BigDecimal(price).multiply(new BigDecimal(num)).toString();
        System.out.println(totalFee);

        String xxx = "aaaaaaaaaassss";
        System.out.println(xxx.substring(0, 20));



    }





}
