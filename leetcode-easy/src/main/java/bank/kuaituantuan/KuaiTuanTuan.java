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
            //ҵ����
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
        System.out.println("��ȡ��ǰϵͳʱ��Ϊ��"+new SimpleDateFormat("yyyy��-MM��dd��-HHʱmm��ss��").format(time));//ת���ɱ�׼�����յ���ʽ
        //Date date = new Date(time);
        time += 30 * 1000 * 60;//�ڵ�ǰϵͳʱ��Ļ����������30����
        System.out.println("��ʮ���Ӻ��ʱ��Ϊ��"+new SimpleDateFormat("yyyy��-MM��dd��-HHʱmm��ss��").format(time));

    }

    List<String> list = new ArrayList<>();





}
