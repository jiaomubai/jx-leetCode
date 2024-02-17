package bank.zhongguanghe;


import cn.com.cgnpc.aep.bizcenter.appcenter.sdk.client.RestClient;
import cn.com.cgnpc.aep.bizcenter.appcenter.sdk.config.AppAccessConfig;
import cn.com.cgnpc.aep.bizcenter.appcenter.sdk.config.Constants;
import cn.com.cgnpc.aep.bizcenter.appcenter.sdk.result.ApiResult;
import cn.com.cgnpc.aep.bizcenter.appcenter.sdk.utils.ValidatorUtil;
import cn.com.cgnpc.aep.bizcenter.appcenter.sdk.vo.CgnRequestHeader;
import com.alibaba.fastjson.JSON;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author jiaoxian
 * @name bank.zhongguanghe
 * @date 2023/7/24 16:25
 * @description TODO
 */
public class ZhongGuangHe {

//    @Autowired
//    private RestClient restClient;

    public void test() {
        CgnRequestHeader cgnRequestHeader = new CgnRequestHeader();
        ApiResult apiResult = null;

//        RestClient restClient = new RestClient();
        RestClientYonyou restClient = new RestClientYonyou();
        String serviceUrl = "/fsm/request";
        String requestUrl = Constants.API_GATEWAY_URL_T + serviceUrl;
        Map<String, Object> paramMap = new HashMap<String, Object>(3);
        paramMap.put("xmlInstr", "requestData");
        paramMap.put("xmlType", "queryacccurrbalance");
        paramMap.put("requestURL", "/itmsservice/recvfsm?target=becs");

        Properties properties = new Properties();
        try {
            properties.load(ZhongGuangHe.class.getClassLoader().getResourceAsStream("application.yml"));
            System.out.println("配置文件内容为:" + JSON.toJSONString(properties));
            System.out.println(properties.getProperty("appId"));
            System.out.println(properties.getProperty("tenantId"));
            System.out.println(new String(properties.getProperty("appName").getBytes(StandardCharsets.ISO_8859_1), "GBK"));



            cgnRequestHeader = CgnRequestHeader.initCgnRequestHeader(
                    Constants.SIGN_API_VERSION,
                    properties.getProperty("tenantId"),
                    "1",
                    properties.getProperty("appId"),
                    properties.getProperty("appKey"),
                    serviceUrl,
                    Constants.API_JSON_RESULT,
                    properties.getProperty("appSecret")
            );
            cgnRequestHeader.setAppId("itms");
            cgnRequestHeader.setAppKey("a000a5a704834fd6bcee35e83371eb4e");
            cgnRequestHeader.setTenantId("1");

        } catch (Exception e) {
            System.out.println("中广核小核心初始化CgnRequestHeader异常:" + e);
        }

//        try {
//            cgnRequestHeader = CgnRequestHeader.initCgnRequestHeader(
//                    Constants.SIGN_API_VERSION,
//                    "1",
//                    "1",
//                    "itms",
//                    "a000a5a704834fd6bcee35e83371eb4e",
//                    serviceUrl,
//                    Constants.API_JSON_RESULT,
//                    "4398bafe013a4761888557e61c7b24e7"
//            );
//
            apiResult = restClient.postCgnMapForRest(requestUrl, cgnRequestHeader, paramMap);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) {


        ZhongGuangHe zhongGuangHe = new ZhongGuangHe();
        zhongGuangHe.test();


    }

}
