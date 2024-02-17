package bank.xiaomiyoupin;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jiaoxian
 * @name bank.xiaomiyoupin
 * @date 2023/6/26 16:43
 * @description TODO
 */
public class Xiaomiyoupin {

    public static void main(String[] args) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date now = simpleDateFormat.parse("2023-06-26 18:00:00");
        String time = String.valueOf(now.getTime());

        System.out.println("Hello World !" + time);
    }


}
