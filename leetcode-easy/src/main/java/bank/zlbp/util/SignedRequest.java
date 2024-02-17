package bank.zlbp.util;

/**
 * @author jiaoxian
 * @name bank.zlbp.util
 * @date 2023/12/13 17:02
 * @description TODO
 */
public class SignedRequest {
    private String instCode;

    private String payload;

    private String timestamp;

    private String nonce;

    private String signature;

    private String nsrsbh;

    protected EncryptTpyeEnum type;

    public SignedRequest(String instCode, String payload, String timestamp, String nonce, String signature) {
        this.instCode = instCode;
        this.payload = payload;
        this.timestamp = timestamp;
        this.nonce = nonce;
        this.signature = signature;
        this.type = EncryptTpyeEnum.AES;
    }

    public SignedRequest(String instCode, String payload, String timestamp, String nonce, String signature, EncryptTpyeEnum type) {
        this.instCode = instCode;
        this.payload = payload;
        this.timestamp = timestamp;
        this.nonce = nonce;
        this.signature = signature;
        this.type = type;
    }

    public SignedRequest(String instCode, String payload, String timestamp, String nonce, String signature, EncryptTpyeEnum type, String nsrsbh) {
        this.instCode = instCode;
        this.payload = payload;
        this.timestamp = timestamp;
        this.nonce = nonce;
        this.nsrsbh = nsrsbh;
        this.signature = signature;
        this.type = type;
    }

    public SignedRequest() {}

    public String getInstCode() {
        return this.instCode;
    }

    public String getPayload() {
        return this.payload;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getNonce() {
        return this.nonce;
    }

    public String getSignature() {
        return this.signature;
    }

    public String getNsrsbh() {
        return this.nsrsbh;
    }

    public EncryptTpyeEnum getType() {
        return this.type;
    }

    public void setInstCode(String instCode) {
        this.instCode = instCode;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void setType(EncryptTpyeEnum type) {
        this.type = type;
    }

    public String toString() {
        return String.format("instCode=%s,payload=%s,timestamp=%s,nonce=%s,signature=%s", new Object[] { getInstCode(), getPayload(), getTimestamp(),
                getNonce(), getSignature() });
    }
}
