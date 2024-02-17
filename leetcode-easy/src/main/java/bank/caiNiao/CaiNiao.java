package bank.caiNiao;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import cn.hutool.core.net.URLEncodeUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.Consts;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * @author jiaoxian
 * @name bank.caiNiao
 * @date 2024/1/18 10:50
 * @description TODO
 */
public class CaiNiao {

    private static CloseableHttpClient httpClient = HttpClients.createDefault();

    protected static <T> T execute(List<BasicNameValuePair> params, String linkUrl, TypeReference<T> typeReference) {

        try {
            return CaiNiao.get(CaiNiao.buildGet(), linkUrl, params, typeReference);
        } catch (URISyntaxException e) {
            throw new RuntimeException("指定服务器[" + e.getMessage() + "]不存在");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static List<BasicNameValuePair> getParams(Map<String, Object> requestParams, String apiName, String providerId, String secretKey) {

        List<BasicNameValuePair> params = new ArrayList<>();
        String msgData = JSON.toJSONString(requestParams);
        System.out.println("msgData:" + msgData);
        String digest = generateLinkDigest(msgData, secretKey);

        params.add(new BasicNameValuePair("logistics_interface", msgData));
        params.add(new BasicNameValuePair("logistic_provider_id", providerId));
        params.add(new BasicNameValuePair("msg_type", apiName));
        params.add(new BasicNameValuePair("data_digest", digest));

        return params;
    }

    protected static <T> T get(HttpGet query, String uri, List<BasicNameValuePair> params, TypeReference<T> typeReference) throws URISyntaxException, IOException {

        String uriNew = URLEncodedUtils.format(params, "UTF-8");
        System.out.println("uriNew:" + uriNew);
        query.setURI(new URI(uri + "?" + uriNew));
        System.out.println("HttpGet:" + JSON.toJSONString(query));

        try (CloseableHttpResponse response = httpClient.execute(query)) {

            return JSON.parseObject(EntityUtils.toString(response.getEntity(), Consts.UTF_8), typeReference);

        }
    }

    protected static HttpGet buildGet() {
        HttpGet httpGet = new HttpGet();
        httpGet.setHeader("Accept", "application/json");
        return httpGet;
    }

    protected static String generateLinkDigest(String content, String keys) {
        String digestContent = content + keys;
        System.out.println("digestContent:" + digestContent);
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(digestContent.getBytes());
            String result = new String(Base64.encodeBase64(md.digest()), StandardCharsets.UTF_8);
            System.out.println("签名结果为:" + result);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws UnsupportedEncodingException {


        String apiName = "CNTECH_LV_LOGISTICS_DETAIL_GET";

        String providerId = "99393e825f2747bed6edbc934c34af36";
        String secretKey = "81v8E25nu1FkvVjO0D8X62DXog51375b";
        String linkUrl = "https://prelink.cainiao.com/gateway/link.do";

        Map<String, Object> requestParams = new HashMap<>();
        Map<String, Object> arg0 = new HashMap<>();
        arg0.put("appCode", "yytest");
        arg0.put("cpCode", "STO");
        arg0.put("mailNo", "777174159154537");
        requestParams.put("arg0", arg0);
        Object result = execute(getParams(requestParams, apiName, providerId, secretKey), linkUrl, new TypeReference<Object>() {});
        System.out.println(JSON.toJSONString(result));


    }




}
