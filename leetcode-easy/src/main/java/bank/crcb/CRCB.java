package bank.crcb;


import com.open.sdk.OpenSDK;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/**
 * @author jiaoxian
 * @name bank.crcb
 * @date 2023/8/7 16:40
 * @description TODO
 */
public class CRCB {

    public void test() {

        String a = "1.23";
        String b = "2.56";

        BigDecimal c = new BigDecimal(a).add(new BigDecimal(b)).setScale(2, RoundingMode.HALF_UP);
    }

    public static void main(String[] args) throws Exception {

        String confPath = "";
        String privateKey = "";
        List<String> filenames = Arrays.asList(confPath);
        File file = new File(confPath);
        try (InputStream is = new FileInputStream(file)) {
            OpenSDK.init(is, privateKey);
//
//            ResponseBean responseBean = OpenSDK.sendFile(filenames, "open");
//            if (!"000000".equals(responseBean.getRspCd())) {
//                System.out.println(responseBean.getRspInf());
//            } else {
//                System.out.println(responseBean.getData());
//            }
        }

    }
}
