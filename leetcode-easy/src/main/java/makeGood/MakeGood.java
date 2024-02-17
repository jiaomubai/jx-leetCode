package makeGood;

import org.apache.http.*;
import org.apache.http.params.HttpParams;

import java.util.Locale;

/**
 * @author jiaoxian
 * @name makeGood
 * @date 2023/10/7 17:05
 * @description leetCode-1544: 整理字符串
 */
public class MakeGood {

    public String makeGood(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = s.length();
        int newLength = s.length();
        if (length % 2 != 0) {
            newLength = length - 1;
        }
        for (int i = 0; i < newLength - 1; i++) {
            char tempA = s.charAt(i);
            char tempB = s.charAt(i + 1);
            if (tempA >= 'A' && tempA <= 'Z') {
                // 大写字母, s[i+1] 不可以是相同的小写字符
                if (tempB - tempA != 32) {
                    stringBuilder.append(tempA).append(tempB);
                }
            } else if (tempA >= 'a' && tempA <= 'z') {
                // 小写字母, s[i+1] 不可以是相同的大写字符
                if (tempA - tempB != 32) {
                    stringBuilder.append(tempA).append(tempB);
                }
            }
        }
        if (newLength != length) {
            stringBuilder.append(s.charAt(s.length() - 1));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        HttpResponse httpResponse =new HttpResponse() {
            @Override
            public StatusLine getStatusLine() {
                return null;
            }

            @Override
            public void setStatusLine(StatusLine statusLine) {

            }

            @Override
            public void setStatusLine(ProtocolVersion protocolVersion, int i) {

            }

            @Override
            public void setStatusLine(ProtocolVersion protocolVersion, int i, String s) {

            }

            @Override
            public void setStatusCode(int i) throws IllegalStateException {

            }

            @Override
            public void setReasonPhrase(String s) throws IllegalStateException {

            }

            @Override
            public HttpEntity getEntity() {
                return null;
            }

            @Override
            public void setEntity(HttpEntity httpEntity) {

            }

            @Override
            public Locale getLocale() {
                return null;
            }

            @Override
            public void setLocale(Locale locale) {

            }

            @Override
            public ProtocolVersion getProtocolVersion() {
                return null;
            }

            @Override
            public boolean containsHeader(String s) {
                return false;
            }

            @Override
            public Header[] getHeaders(String s) {
                return new Header[0];
            }

            @Override
            public Header getFirstHeader(String s) {
                return null;
            }

            @Override
            public Header getLastHeader(String s) {
                return null;
            }

            @Override
            public Header[] getAllHeaders() {
                return new Header[0];
            }

            @Override
            public void addHeader(Header header) {

            }

            @Override
            public void addHeader(String s, String s1) {

            }

            @Override
            public void setHeader(Header header) {

            }

            @Override
            public void setHeader(String s, String s1) {

            }

            @Override
            public void setHeaders(Header[] headers) {

            }

            @Override
            public void removeHeader(Header header) {

            }

            @Override
            public void removeHeaders(String s) {

            }

            @Override
            public HeaderIterator headerIterator() {
                return null;
            }

            @Override
            public HeaderIterator headerIterator(String s) {
                return null;
            }

            @Override
            public HttpParams getParams() {
                return null;
            }

            @Override
            public void setParams(HttpParams httpParams) {

            }
        };


        HttpEntity httpEntity = httpResponse.getEntity();

        System.out.println(new MakeGood().makeGood("leEeetcode"));
    }

}
