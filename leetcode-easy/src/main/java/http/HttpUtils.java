//package http;
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.HttpStatus;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.ContentType;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//import org.springframework.http.RequestEntity;
//
//import javax.net.ssl.*;
//import java.io.*;
//import java.net.*;
//import java.nio.charset.StandardCharsets;
//import java.security.cert.X509Certificate;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//
//
//import org.apache.commons.httpclient.methods.PostMethod;
//import org.apache.commons.httpclient.methods.StringRequestEntity;
//
//
///**
// * @author jiaoxian
// * @name http
// * @date 2023/10/30 18:38
// * @description TODO
// */
//@Slf4j
//public class HttpUtils {
//
//    /**
//     * HTTP���󹤾���
//     *
//     * @author xiegege
//     */
//    private static HttpClient httpClient;
//
//    static {
//        httpClient = getHttpClient();
//    }
//
//    /**
//     * ΢��ͳһ�µ��ӿڷ���post����
//     *
//     * @param url        ���������URL
//     * @param requestXml mapת��xml�ı���
//     * @return ������Զ����Դ����Ӧ���
//     */
//    public static String doPost(String url, String requestXml) {
//        CloseableHttpClient httpClient;
//        CloseableHttpResponse httpResponse;
//        // ����httpClient���Ӷ���
//        httpClient = HttpClients.createDefault();
//        // ����post�������Ӷ���
//        HttpPost httpPost = new HttpPost(url);
//        // ���������������,���������Ӳ���
//        RequestConfig requestConfig = RequestConfig.custom()
//                .setConnectTimeout(15000)   // ���ӷ�����������ʱʱ��
//                .setConnectionRequestTimeout(60000) // ��������ʱʱ��
//                .setSocketTimeout(60000).build(); // ���ö�ȡ��Ӧ���ݳ�ʱʱ��
//        // Ϊhttppost�������ò���
//        httpPost.setConfig(requestConfig);
//        // ���ϴ������ŵ�entity������
//        httpPost.setEntity(new StringEntity(requestXml, "UTF-8"));
//        // ���ͷ��Ϣ
//        httpPost.addHeader("Content-type", "text/xml");
//        String result = "";
//        try {
//            // ��������
//            httpResponse = httpClient.execute(httpPost);
//            // ����Ӧ�����л�ȡ��������
//            HttpEntity entity = httpResponse.getEntity();
//            result = EntityUtils.toString(entity, "UTF-8");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//    /**
//     * ��ָ�� URL ����GET����������
//     *
//     * @param url   ��������� URL
//     * @param param ����������������Ӧ���� name1=value1&name2=value2 ����ʽ��
//     * @return ������Զ����Դ����Ӧ���
//     */
//    public static String sendGet(String url, String param) {
//        return sendGet(url, param, "UTF-8");
//    }
//
//    /**
//     * ��ָ�� URL ����GET����������
//     *
//     * @param url         ��������� URL
//     * @param param       ����������������Ӧ���� name1=value1&name2=value2 ����ʽ��
//     * @param contentType ��������
//     * @return ������Զ����Դ����Ӧ���
//     */
//    public static String sendGet(String url, String param, String contentType) {
//        StringBuilder result = new StringBuilder();
//        BufferedReader in = null;
//        try {
//            String urlNameString = url + "?" + param;
//            //log.info("sendGet - {}", urlNameString);
//            URL realUrl = new URL(urlNameString);
//            URLConnection connection = realUrl.openConnection();
//            connection.setRequestProperty("accept", "*/*");
//            connection.setRequestProperty("connection", "Keep-Alive");
//            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            connection.connect();
//            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), contentType));
//            String line;
//            while ((line = in.readLine()) != null) {
//                result.append(line);
//            }
//            //log.info("recv - {}", result);
//        } catch (ConnectException e) {
//            //log.error("����HttpUtils.sendGet ConnectException, url=" + url + ",param=" + param, e);
//        } catch (SocketTimeoutException e) {
//            //log.error("����HttpUtils.sendGet SocketTimeoutException, url=" + url + ",param=" + param, e);
//        } catch (IOException e) {
//            //log.error("����HttpUtils.sendGet IOException, url=" + url + ",param=" + param, e);
//        } catch (Exception e) {
//            //log.error("����HttpsUtil.sendGet Exception, url=" + url + ",param=" + param, e);
//        } finally {
//            try {
//                if (in != null) {
//                    in.close();
//                }
//            } catch (Exception ex) {
//                //log.error("����in.close Exception, url=" + url + ",param=" + param, ex);
//            }
//        }
//        return result.toString();
//    }
//
//    /**
//     * ��ָ�� URL ����POST����������
//     *
//     * @param url   ��������� URL
//     * @param param ����������������Ӧ���� name1=value1&name2=value2 ����ʽ��
//     * @return ������Զ����Դ����Ӧ���
//     */
//    public static String sendPost(String url, String param) {
//        PrintWriter out = null;
//        BufferedReader in = null;
//        StringBuilder result = new StringBuilder();
//        try {
//            //log.info("sendPost - {}", url);
//            URL realUrl = new URL(url);
//            URLConnection conn = realUrl.openConnection();
//            conn.setRequestProperty("accept", "*/*");
//            conn.setRequestProperty("connection", "Keep-Alive");
//            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            conn.setRequestProperty("Accept-Charset", "utf-8");
//            conn.setRequestProperty("contentType", "utf-8");
//            conn.setDoOutput(true);
//            conn.setDoInput(true);
//            out = new PrintWriter(conn.getOutputStream());
//            out.print(param);
//            out.flush();
//            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
//            String line;
//            while ((line = in.readLine()) != null) {
//                result.append(line);
//            }
//            //log.info("recv - {}", result);
//        } catch (ConnectException e) {
//            //log.error("����HttpUtils.sendPost ConnectException, url=" + url + ",param=" + param, e);
//        } catch (SocketTimeoutException e) {
//            //log.error("����HttpUtils.sendPost SocketTimeoutException, url=" + url + ",param=" + param, e);
//        } catch (IOException e) {
//            //log.error("����HttpUtils.sendPost IOException, url=" + url + ",param=" + param, e);
//        } catch (Exception e) {
//            //log.error("����HttpsUtil.sendPost Exception, url=" + url + ",param=" + param, e);
//        } finally {
//            try {
//                if (out != null) {
//                    out.close();
//                }
//                if (in != null) {
//                    in.close();
//                }
//            } catch (IOException ex) {
//                log.error("����in.close Exception, url=" + url + ",param=" + param, ex);
//            }
//        }
//        return result.toString();
//    }
//
//    public static String sendSSLPost(String url, String param) {
//        StringBuilder result = new StringBuilder();
//        String urlNameString = url + "?" + param;
//        try {
//            log.info("sendSSLPost - {}", urlNameString);
//            SSLContext sc = SSLContext.getInstance("SSL");
//            sc.init(null, new TrustManager[]{new TrustAnyTrustManager()}, new java.security.SecureRandom());
//            URL console = new URL(urlNameString);
//            HttpsURLConnection conn = (HttpsURLConnection) console.openConnection();
//            conn.setRequestProperty("accept", "*/*");
//            conn.setRequestProperty("connection", "Keep-Alive");
//            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            conn.setRequestProperty("Accept-Charset", "utf-8");
//            conn.setRequestProperty("contentType", "utf-8");
//            conn.setDoOutput(true);
//            conn.setDoInput(true);
//
//            conn.setSSLSocketFactory(sc.getSocketFactory());
//            conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
//            conn.connect();
//            InputStream is = conn.getInputStream();
//            BufferedReader br = new BufferedReader(new InputStreamReader(is));
//            String ret;
//            while ((ret = br.readLine()) != null) {
//                if (!"".equals(ret.trim())) {
//                    result.append(new String(ret.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
//                }
//            }
//            log.info("recv - {}", result);
//            conn.disconnect();
//            br.close();
//        } catch (ConnectException e) {
//            log.error("����HttpUtils.sendSSLPost ConnectException, url=" + url + ",param=" + param, e);
//        } catch (SocketTimeoutException e) {
//            log.error("����HttpUtils.sendSSLPost SocketTimeoutException, url=" + url + ",param=" + param, e);
//        } catch (IOException e) {
//            log.error("����HttpUtils.sendSSLPost IOException, url=" + url + ",param=" + param, e);
//        } catch (Exception e) {
//            log.error("����HttpsUtil.sendSSLPost Exception, url=" + url + ",param=" + param, e);
//        }
//        return result.toString();
//    }
//
//    /**
//     * Http Get���� �����ַ
//     *
//     * @param url    Get����
//     * @param params ����
//     * @param encode ����������
//     */
//    public static String sendGetRequest(String url, Map<String, String> params, String encode) {
//        String result = null;
//        try {
//            HttpGet httpGet;
//            if (null == params) {
//                httpGet = new HttpGet(url);
//            } else {
//                httpGet = new HttpGet(url + dealGetParams(params, encode));
//            }
//            HttpResponse response = httpClient.execute(httpGet);
//            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//                result = EntityUtils.toString(response.getEntity());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return result != null ? result : "";
//    }
//
//    public static String sendGetRequest(String url, Map<String, String> params) {
//        return sendGetRequest(url, params, "UTF-8");
//    }
//
//    public static String sendGetRequest(String url) {
//        return sendGetRequest(url, null, "UTF-8");
//    }
//
//    public static String sendGetRequestGB2312(String url) {
//        return sendGetRequest(url, null, "GB2312");
//    }
//
//    /**
//     * POST���� ���������� HashMap��ֵ����
//     */
//    @SuppressWarnings({"unchecked"})
//    public static String sendPostRequest(String url, String header, Object params, String encode) throws Exception {
//        String resultStr = null;
//        HttpPost httpPost = new HttpPost(url);
//        if (params != null) {
//            StringEntity entity;
//            if (params instanceof Map) {
//                entity = new StringEntity(dealPostParams((HashMap<String, String>) params, encode));
//            } else if (params instanceof String) {
//                entity = new StringEntity((String) params, encode);
//            } else if (params instanceof List) {
//                entity = new UrlEncodedFormEntity((List<? extends NameValuePair>) params, encode);
//            } else {
//                throw new Exception("��������!");
//            }
//            httpPost.setHeader("Content-Type", "application/json");
//            httpPost.setHeader("Client-Sign", header);
//            httpPost.setEntity(entity);
//        }
//        try {
//            HttpResponse response = httpClient.execute(httpPost);
//            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//                resultStr = EntityUtils.toString(response.getEntity());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return resultStr;
//    }
//
//    public static String sendPostRequest(String url, String header) throws Exception {
//        return sendPostRequest(url, header, "");
//    }
//
//    /**
//     * ��ֵ������ Ĭ��UTF-8����
//     */
//    public static String sendPostRequest(String url, String header, Map<String, String> params) throws Exception {
//        return sendPostRequest(url, header, params, "UTF-8");
//    }
//
//    /**
//     * String Ĭ��UTF-8����
//     */
//    public static String sendPostRequest(String url, String header, String params) throws Exception {
//        return sendPostRequest(url, header, params, "UTF-8");
//    }
//
//    /**
//     * ��ֵ������ Ĭ��UTF-8����
//     */
//    public static String sendPostRequest(String url, String header, List<NameValuePair> params) throws Exception {
//        return sendPostRequest(url, header, params, "UTF-8");
//    }
//
//    /**
//     * ����Get��ʽ�����URL
//     */
//    private static String dealGetParams(Map<String, String> params, String enc) throws UnsupportedEncodingException {
//        StringBuffer sb = new StringBuffer();
//        sb.append("?");
//        for (Map.Entry<String, String> entry : params.entrySet()) {
//            // ������=����&������=����
//            sb.append(entry.getKey()).append("=")
//                    .append(URLEncoder.encode(entry.getValue(), enc))
//                    .append("&");
//        }
//        // ɾ�����һ��&
//        sb.deleteCharAt(sb.length() - 1);
//        return sb.toString();
//    }
//
//    /**
//     * ����POST����URL
//     */
//    private static String dealPostParams(Map<String, String> params, String enc) {
//        StringBuffer sb = new StringBuffer();
//        for (Map.Entry<String, String> entry : params.entrySet()) {
//            try {
//                sb.append(entry.getKey()).append("=")
//                        .append(URLEncoder.encode(entry.getValue(), enc))
//                        .append("&");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//        }
//        sb.deleteCharAt(sb.length() - 1);
//        return sb.toString();
//    }
//
//    /**
//     * ��ȡHttpClient
//     */
//    @SuppressWarnings("deprecation")
//    public static synchronized HttpClient getHttpClient() {
//        if (null == httpClient) {
//            httpClient = new DefaultHttpClient();
//        }
//        return httpClient;
//    }
//
//    private static class TrustAnyTrustManager implements X509TrustManager {
//        @Override
//        public void checkClientTrusted(X509Certificate[] chain, String authType) {
//        }
//
//        @Override
//        public void checkServerTrusted(X509Certificate[] chain, String authType) {
//        }
//
//        @Override
//        public X509Certificate[] getAcceptedIssuers() {
//            return new X509Certificate[]{};
//        }
//    }
//
//    private static class TrustAnyHostnameVerifier implements HostnameVerifier {
//        @Override
//        public boolean verify(String hostname, SSLSession session) {
//            return true;
//        }
//    }
//
//    public static String doPostJson(String url, String json) {
//
//        // ����Httpclient����
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        CloseableHttpResponse response = null;
//        String resultString = "";
//        try {
//            // ����Http Post����
//            HttpPost httpPost = new HttpPost(url);
//            // ������������
//            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
//            httpPost.setEntity(entity);
//            // ִ��http����
//            response = httpClient.execute(httpPost);
//            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                response.close();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//
//        return resultString;
//    }
//
//}
//
//
//
