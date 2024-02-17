package bank.kuaituantuan;

import com.alibaba.fastjson.JSON;
import com.pdd.pop.sdk.common.util.JsonUtil;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.PopHttpClient;
import com.pdd.pop.sdk.http.api.pop.request.PddOrderBasicListGetRequest;
import com.pdd.pop.sdk.http.api.pop.response.PddOrderBasicListGetResponse;
import com.pdd.pop.sdk.message.MessageHandler;
import com.pdd.pop.sdk.message.WsClient;
import com.pdd.pop.sdk.message.model.Message;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author jiaoxian
 * @name bank.kuaituantuan
 * @date 2023/6/9 16:23
 * @description TODO
 */
public class KuaiTuanTuan {


    private static PddOrderBasicListGetResponse pddOrderBasicListGetResponse = new PddOrderBasicListGetResponse();

    WsClient ws = new WsClient(
            "wss://message-api.pinduoduo.com", "your clientId",
            "your clientSecret", new MessageHandler() {
        @Override
        public void onMessage(Message message) throws InterruptedException {
            //业务处理
            ws.connect();
        }
    });


    public static PopClient popClient = new PopHttpClient("", "");

    public static void main(String[] args) throws Exception {

//        String res;
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = simpleDateFormat.parse("2023-10-10 10:00:20");
//        String ts = String.valueOf(date.getTime() / 1000);
//        System.out.println(String.valueOf(ts));

        Long time = System.currentTimeMillis();
        System.out.println("获取当前系统时间为："+new SimpleDateFormat("yyyy年-MM月dd日-HH时mm分ss秒").format(time));//转换成标准年月日的形式
        //Date date = new Date(time);
        time += 30 * 1000 * 60;//在当前系统时间的基础上往后加30分钟
        System.out.println("三十分钟后的时间为："+new SimpleDateFormat("yyyy年-MM月dd日-HH时mm分ss秒").format(time));

    }

    List<String> list = new ArrayList<>();





}
