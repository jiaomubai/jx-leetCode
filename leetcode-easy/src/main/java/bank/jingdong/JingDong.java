package bank.jingdong;

import com.jd.open.api.sdk.DefaultJdClient;
import com.jd.open.api.sdk.JdClient;
import com.jd.open.api.sdk.request.order.PopOrderEnGetRequest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jiaoxian
 * @name bank.jingdong
 * @date 2023/7/19 9:56
 * @description TODO
 */
public class JingDong {

    public JdClient client = new DefaultJdClient("SERVER_URL", "", "", "appSecret");

    public static void main(String[] args) throws Exception {

//        String time = "1688458266000";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        long timeStamp = Long.parseLong(time);
//        Date date = new Date(timeStamp);
//        System.out.println(simpleDateFormat.format(date));
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(sdf.parse("2023-07-01 00:00:00").getTime());

        String string = "113456.788410";
        string = new BigDecimal(string).setScale(2, RoundingMode.HALF_UP).toString();
        System.out.println(string);


//        JdClient client = new DefaultJdClient("SERVER_URL", "", "", "appSecret");
//        client.execute(new PopOrderEnGetRequest());
    }

}
