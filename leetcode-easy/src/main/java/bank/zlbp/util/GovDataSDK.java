package bank.zlbp.util;

/**
 * @author jiaoxian
 * @name bank.zlbp.util
 * @date 2023/12/13 16:57
 * @description TODO
 */
import java.nio.charset.Charset;

public class GovDataSDK {

    private static GovDataSDK ourInstance = new GovDataSDK();

    private String instCode;

    private RequestBuilder requestBuilder;

    private RequestParser requestParser;

    public static GovDataSDK getInstance() {
        return ourInstance;
    }

    public void init(String instCode, String priKeyContent, String password, EncryptTpyeEnum type) {
        this.instCode = instCode;
        this.requestBuilder = new RequestBuilder(this.instCode, type, priKeyContent.getBytes(Charset.forName("utf-8")), password);
        this.requestParser = new RequestParser(priKeyContent.getBytes(Charset.forName("utf-8")), password, type);
    }

    public RequestBuilder getRequestBuilder() {
        return this.requestBuilder;
    }

    public RequestParser getRequestParser() {
        return this.requestParser;
    }

}
