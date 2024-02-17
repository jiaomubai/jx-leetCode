package bank.zlbp.dto;

/**
 * @author jiaoxian
 * @name bank.zlbp.dto
 * @date 2023/11/27 11:16
 * @description TODO
 */
public class GetInvoiceFilePackageCountDTO {

    private String requestId;

    private String nsrsbh;

    private String jgrq;

    private String gxfbs;

    private String authorizedNsrsbh;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getNsrsbh() {
        return nsrsbh;
    }

    public void setNsrsbh(String nsrsbh) {
        this.nsrsbh = nsrsbh;
    }

    public String getJgrq() {
        return jgrq;
    }

    public void setJgrq(String jgrq) {
        this.jgrq = jgrq;
    }

    public String getGxfbs() {
        return gxfbs;
    }

    public void setGxfbs(String gxfbs) {
        this.gxfbs = gxfbs;
    }

    public String getAuthorizedNsrsbh() {
        return authorizedNsrsbh;
    }

    public void setAuthorizedNsrsbh(String authorizedNsrsbh) {
        this.authorizedNsrsbh = authorizedNsrsbh;
    }
}
