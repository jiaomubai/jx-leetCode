package bank.caiNiao;

/**
 * @author jiaoxian
 * @name bank.caiNiao
 * @date 2024/1/18 13:51
 * @description TODO
 */
public class GetLogisticDetailDTO {

    private String appCode;

    private String cpCode;

    private String mailNo;

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getCpCode() {
        return cpCode;
    }

    public void setCpCode(String cpCode) {
        this.cpCode = cpCode;
    }

    public String getMailNo() {
        return mailNo;
    }

    public void setMailNo(String mailNo) {
        this.mailNo = mailNo;
    }
}
