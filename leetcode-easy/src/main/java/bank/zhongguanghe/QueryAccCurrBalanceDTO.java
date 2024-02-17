package bank.zhongguanghe;

import java.net.URI;

/**
 * @author jiaoxian
 * @name bank.zhongguanghe
 * @date 2023/8/4 15:18
 * @description TODO
 */
public class QueryAccCurrBalanceDTO {

    private String xmlInstr;

    private String xmlType;

    private String requestURL;

    public String getXmlInstr() {
        return xmlInstr;
    }

    public void setXmlInstr(String xmlInstr) {
        this.xmlInstr = xmlInstr;
    }

    public String getXmlType() {
        return xmlType;
    }

    public void setXmlType(String xmlType) {
        this.xmlType = xmlType;
    }

    public String getRequestURL() {
        return requestURL;
    }

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public static void main(String[] args) {
        URI uri = URI.create("https://aepgw-t.gnpjvc.cgnpc.com.cn/fsmchannel/serviceRequest");
        String ip = uri.getHost();
        String port = uri.getPort() + "";
        String serviceUrl = uri.getPath();


    }


}
