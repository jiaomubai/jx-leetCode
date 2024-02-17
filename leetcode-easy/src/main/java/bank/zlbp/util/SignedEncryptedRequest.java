package bank.zlbp.util;

/**
 * @author jiaoxian
 * @name bank.zlbp.util
 * @date 2023/12/13 17:34
 * @description TODO
 */
public class SignedEncryptedRequest extends SignedRequest {
    private String envelop;

    public SignedEncryptedRequest(String instCode, String payload, String timestamp, String nonce, String signature, String envelop, EncryptTpyeEnum type) {
        super(instCode, payload, timestamp, nonce, signature, type);
        this.envelop = envelop;
    }

    public SignedEncryptedRequest() {}

    public String getEnvelop() {
        return this.envelop;
    }

    public void setEnvelop(String envelop) {
        this.envelop = envelop;
    }
}
