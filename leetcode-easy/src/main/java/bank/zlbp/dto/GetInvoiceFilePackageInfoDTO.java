package bank.zlbp.dto;

/**
 * @author jiaoxian
 * @name bank.zlbp.dto
 * @date 2023/12/13 18:01
 * @description TODO
 */
public class GetInvoiceFilePackageInfoDTO {

    private String requestId;

    private String nsrsbh;

    private String pageNumber;

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

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }
}
