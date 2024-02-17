package bank.zlbp.util;

/**
 * @author jiaoxian
 * @name bank.zlbp.util
 * @date 2023/12/13 17:00
 * @description TODO
 */
import java.io.ByteArrayInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RequestParser {
    private final byte[] privateKey;

    private final String password;

    private EncryptTpyeEnum type;

    public RequestParser(byte[] privateKey, String password, EncryptTpyeEnum type) {
        this.privateKey = privateKey;
        this.password = password;
        this.type = type;
    }
//
//    public byte[] decryptEncryptedRequest(SignedEncryptedRequest request) throws BadPaddingException, IllegalBlockSizeException, NoSuchProviderException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
//        byte[] envelop = LiteBase64.getDecoder().decode(request.getEnvelop());
//        byte[] decryptPassword = getDecrypt().decrypt(envelop);
//        byte[] encryptedPayload = LiteBase64.getDecoder().decode(request.getPayload());
//        if (this.type == EncryptTpyeEnum.AES || this.type == EncryptTpyeEnum.RSA)
//            return SymmetricFactory.createCipher(SymmetricCipherEnum.AES).decrypt(encryptedPayload, decryptPassword);
//        if (this.type == EncryptTpyeEnum.SM4)
//            return SymmetricFactory.createCipher(SymmetricCipherEnum.SM4).decrypt(encryptedPayload, decryptPassword);
//        throw new RuntimeException("decrypt type not support.");
//    }
//
//    private AsymmetricCipher getDecrypt() {
//        try {
//            if (this.type == EncryptTpyeEnum.AES) {
//                ByteArrayInputStream in = new ByteArrayInputStream(this.privateKey);
//                AsymmetricCipher cipher = AsymmetricFactory.createDecryptCipher(AsymmetricCipherEnum.SECP256K1, in, this.password);
//                in.close();
//                return cipher;
//            }
//            if (this.type == EncryptTpyeEnum.SM4) {
//                ByteArrayInputStream in = new ByteArrayInputStream(this.privateKey);
//                AsymmetricCipher cipher = AsymmetricFactory.createDecryptCipher(AsymmetricCipherEnum.SM2, in, this.password);
//                in.close();
//                return cipher;
//            }
//            if (this.type == EncryptTpyeEnum.RSA) {
//                ByteArrayInputStream in = new ByteArrayInputStream(this.privateKey);
//                AsymmetricCipher cipher = AsymmetricFactory.createDecryptCipher(AsymmetricCipherEnum.RSA2048, in, this.password);
//                in.close();
//                return cipher;
//            }
//        } catch (Exception e) {
//            throw new RuntimeException("create decrypt fails ", e);
//        }
//        throw new IllegalStateException("unknown encrypt type");
//    }
}

