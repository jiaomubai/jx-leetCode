package bank.zlbp.util;

/**
 * @author jiaoxian
 * @name bank.zlbp.util
 * @date 2023/12/13 17:36
 * @description TODO
 */

public enum AsymmetricCipherEnum {
    RSA2048(null, "RSA"),
    SM2("sm2p256v1", "EC"),
    SECP256K1("secp256k1", "EC");

    private String curveName;

    private String algorithm;

    AsymmetricCipherEnum(String curveName, String algorithm) {
        this.curveName = curveName;
        this.algorithm = algorithm;
    }

    public String getCurveName() {
        return this.curveName;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }
}

