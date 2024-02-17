package bank.zlbp.util;

/**
 * @author jiaoxian
 * @name bank.zlbp.util
 * @date 2023/12/13 16:58
 * @description TODO
 */
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.util.Random;
import javax.crypto.NoSuchPaddingException;

public class RequestBuilder {
    private final String instCode;

    private final EncryptTpyeEnum type;

    private final byte[] privateKey;

    private String publicKey;

    private final String password;

    public RequestBuilder(String instCode, byte[] privateKey, String password) {
        this.instCode = instCode;
        this.type = EncryptTpyeEnum.AES;
        this.privateKey = privateKey;
        this.password = password;
    }

    public RequestBuilder(String instCode, EncryptTpyeEnum type, byte[] privateKey, String password) {
        this.instCode = instCode;
        this.type = type;
        this.privateKey = privateKey;
        this.password = password;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
//
//    public SignedRequest generateSignedPayload(String jsonString) {
//        byte[] content = jsonString.getBytes(Charset.forName("utf-8"));
//        return generateSignedPayload(content);
//    }
//
//    public SignedRequest generateSignedPayload(byte[] content) {
//        String payload = LiteBase64.getEncoder().encodeToString(content);
//        long timestamp = System.currentTimeMillis() / 1000L;
//        String nonce = String.valueOf((int)((Math.random() * 9.0D + 1.0D) * 100000.0D));
//        byte[] signPayloadBody = (this.instCode + payload + timestamp + nonce).getBytes();
//        byte[] signature = getSigner().sign(signPayloadBody);
//        String signatureString = HexUtils.toHexString(signature);
//        return new SignedRequest(this.instCode, payload, String.valueOf(timestamp), nonce, signatureString, this.type);
//    }
//
//    public SignedEncryptedRequest generateSignedEncryptedPayload(String jsonString) {
//        Random random = new Random();
//        byte[] randomPass = new byte[16];
//        random.nextBytes(randomPass);
//        return generateSignedEncryptedPayload(jsonString, randomPass);
//    }
//
//    public SignedEncryptedRequest generateSignedEncryptedPayload(byte[] content) {
//        Random random = new Random();
//        byte[] randomPass = new byte[16];
//        random.nextBytes(randomPass);
//        return generateSignedEncryptedPayload(content, randomPass);
//    }
//
//    public SignedEncryptedRequest generateSignedEncryptedPayload(String jsonString, byte[] inputPassword) {
//        byte[] jsonBytes = jsonString.getBytes(Charset.forName("utf-8"));
//        return generateSignedEncryptedPayload(jsonBytes, inputPassword);
//    }
//
//    public SignedEncryptedRequest generateSignedEncryptedPayload(byte[] content, byte[] inputPassword) {
//        return generateSignedEncryptedPayload(content, inputPassword, null);
//    }
//
//    public SignedEncryptedRequest generateSignedEncryptedPayload(byte[] content, byte[] inputPassword, String inputPublicKey) {
//        byte[] encryptedContent, envelopContent;
//        if (this.publicKey == null && inputPublicKey == null) {
//            throw new IllegalStateException("server public key not config");
//        }
//        byte[] jsonBytes = content;
//        try {
//            if (this.type == EncryptTpyeEnum.AES || this.type == EncryptTpyeEnum.RSA) {
//                byte[] kdfPassword = DigestFactory.calculateSha256(inputPassword);
//                encryptedContent = SymmetricFactory.createCipher(SymmetricCipherEnum.AES).encrypt(jsonBytes, kdfPassword);
//                envelopContent = getEncrypt(inputPublicKey).encrypt(kdfPassword);
//            } else if (this.type == EncryptTpyeEnum.SM4) {
//                if (inputPassword.length != 16)
//                    throw new IllegalArgumentException("passcode length should be 16");
//                encryptedContent = SymmetricFactory.createCipher(SymmetricCipherEnum.SM4).encrypt(jsonBytes, inputPassword);
//                envelopContent = getEncrypt(inputPublicKey).encrypt(inputPassword);
//            } else {
//                throw new IllegalArgumentException("unknown encrypt type " + this.type.name());
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        String payload = LiteBase64.getEncoder().encodeToString(encryptedContent);
//        String envelop = LiteBase64.getEncoder().encodeToString(envelopContent);
//        long timestamp = System.currentTimeMillis() / 1000L;
//        String nonce = String.valueOf((int)((Math.random() * 9.0D + 1.0D) * 100000.0D));
//        byte[] signPayloadBody = (this.instCode + payload + timestamp + nonce).getBytes();
//        byte[] signature = getSigner().sign(signPayloadBody);
//        String signatureString = HexUtils.toHexString(signature);
//        return new SignedEncryptedRequest(this.instCode, payload, String.valueOf(timestamp), nonce, signatureString, envelop, this.type);
//        return null;
//    }
//
//    private DsaSigner getSigner() {
//        try {
//            if (this.type == EncryptTpyeEnum.AES) {
//                ByteArrayInputStream in = new ByteArrayInputStream(this.privateKey);
//                DsaSigner signer = AsymmetricFactory.createSigner(AsymmetricCipherEnum.SECP256K1, DigestEnum.SHA256, in, this.password);
//                in.close();
//                return signer;
//            }
//            if (this.type == EncryptTpyeEnum.SM4) {
//                ByteArrayInputStream in = new ByteArrayInputStream(this.privateKey);
//                DsaSigner signer = AsymmetricFactory.createSigner(AsymmetricCipherEnum.SM2, DigestEnum.SM3, in, this.password);
//                in.close();
//                return signer;
//            }
//            if (this.type == EncryptTpyeEnum.RSA) {
//                ByteArrayInputStream in = new ByteArrayInputStream(this.privateKey);
//                DsaSigner signer = AsymmetricFactory.createSigner(AsymmetricCipherEnum.RSA2048, DigestEnum.SHA256, in, this.password);
//                in.close();
//                return signer;
//            }
//        } catch (Exception e) {
//            throw new RuntimeException("create signer fails", e);
//        }
//        throw new IllegalStateException("unknown encrypt type");
//    }
//
//    private AsymmetricCipher getEncrypt(String inputPublicKey) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, NoSuchProviderException, InvalidKeyException, InvalidKeySpecException {
//        String pk = null;
//        if (inputPublicKey != null) {
//            pk = inputPublicKey;
//        } else {
//            pk = this.publicKey;
//        }
//        if (this.type == EncryptTpyeEnum.AES) {
//            AsymmetricCipher cipher = AsymmetricFactory.createEncryptCipher(AsymmetricCipherEnum.SECP256K1, pk);
//            return cipher;
//        }
//        if (this.type == EncryptTpyeEnum.SM4) {
//            AsymmetricCipher cipher = AsymmetricFactory.createEncryptCipher(AsymmetricCipherEnum.SM2, pk);
//            return cipher;
//        }
//        if (this.type == EncryptTpyeEnum.RSA) {
//            AsymmetricCipher cipher = AsymmetricFactory.createEncryptCipher(AsymmetricCipherEnum.RSA2048, pk);
//            return cipher;
//        }
//        throw new IllegalStateException("unknown encrypt type");
//    }
}
