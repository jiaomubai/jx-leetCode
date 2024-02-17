package bank.leqi;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;
import org.bouncycastle.util.encoders.Hex;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Arrays;
import java.util.Base64;

/**
 * @author jiaoxian
 * @name bank.leqi
 * @date 2023/11/7 8:39
 * @description TODO
 */
public class LeQi2 {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    private static final Charset ENCODING = StandardCharsets.UTF_8;
    public static final String ALGORITHM_NAME = "SM4";
    // 加密算法/分组加密模式/分组填充方式
    // PKCS5Padding-以8个字节为一组进行分组加密
    // 定义分组加密模式使用：PKCS5Padding
    public static final String ALGORITHM_NAME_ECB_PADDING = "SM4/ECB/PKCS5Padding";


    /**
     * 生成ECB暗号
     *
     * @param algorithmName 算法名称
     * @param mode          模式
     * @param key           密码
     * @explain ECB模式（电子密码本模式：Electronic codebook）
     */
    private static Cipher generateEcbCipher(String algorithmName, int mode, byte[] key) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithmName, BouncyCastleProvider.PROVIDER_NAME);
        Key sm4Key = new SecretKeySpec(key, ALGORITHM_NAME);
        cipher.init(mode, sm4Key);
        return cipher;
    }

    /**
     * sm4加密
     *
     * @param hexKey   16进制密钥（忽略大小写）
     * @param paramStr 待加密字符串
     * @return 返回Base64后加密字符串
     * @explain 加密模式：ECB
     */
    public static String encryptEcb(String hexKey, String paramStr) throws Exception {
        // 16进制字符串-->byte[]
        byte[] keyData = ByteUtils.fromHexString(hexKey);
        // String-->byte[]
        byte[] srcData = paramStr.getBytes(ENCODING);
        // 加密后的数组
        byte[] cipherArray = encrypt_Ecb_Padding(keyData, srcData);
        // byte[]-->hexString
        String cipherText = Base64.getEncoder().encodeToString(cipherArray);
        return cipherText;
    }

    /**
     * 加密模式为ECB
     *
     * @param key  2进制密钥
     * @param data 2进制原文
     * @return 二进制密文
     */
    public static byte[] encrypt_Ecb_Padding(byte[] key, byte[] data) throws Exception {
        Cipher cipher = generateEcbCipher(ALGORITHM_NAME_ECB_PADDING, Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    /**
     * sm4解密
     *
     * @param hexKey     16进制密钥
     * @param cipherText 16进制的加密字符串（忽略大小写）
     * @return 解密后的字符串
     * @explain 解密模式：采用ECB
     */
    @SuppressWarnings("UnnecessaryLocalVariable")
    public static String decryptEcb(String hexKey, String cipherText) throws Exception {
        // hexString-->byte[]
        byte[] keyData = ByteUtils.fromHexString(hexKey);
        // hexString-->byte[]
        byte[] cipherData = Base64.getDecoder().decode(cipherText);
        // 解密
        byte[] srcData = decrypt_Ecb_Padding(keyData, cipherData);
        // 接收解密后的字符串 byte[]-->String
        String decryptStr = new String(srcData, ENCODING);
        return decryptStr;
    }

    /**
     * sm4解密
     *
     * @param key  2进制密钥
     * @param cipherText 2进制密文
     * @return 解密后的2进制原文
     */
    public static byte[] decrypt_Ecb_Padding(byte[] key, byte[] cipherText) throws Exception {
        Cipher cipher = generateEcbCipher(ALGORITHM_NAME_ECB_PADDING, Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(cipherText);
    }



    public static void main(String[] args) {
        /*
        try {
            String nsrsbh = "91440700719259080H";

            TestNsr testNsr = new TestNsr();
            testNsr.setNsrsbh(nsrsbh);
//            testNsr.setLysl(100);
            String s = JSON.toJSON(testNsr).toString();
//            String paramStr = "{nsfrshb:91440700719259080H}";

            System.out.println(s);

//            s = "{\"nsrsbh\":\"91440700719259080\"}";

//            String paramStr = "加密原文 original text";
            System.out.println("==========加密前源数据==========");
            System.out.println(s);
            // 生成32位16进制密钥
//            String key = LeQi2.generateKey();
//            System.out.println("==========生成key==========");
//            System.out.println(key);
            String key = "eed467ac3b21eb08248653dc33bbfe84";
            String cipher = LeQi2.encryptEcb(key, s);
            System.out.println("==========加密串==========");
            System.out.println(cipher);
            System.out.println("==========是否为同一数据==========");
//            System.out.println(LeQi2.verifyEcb(key, cipher, s));
            s = LeQi2.decryptEcb(key, cipher);
            System.out.println("==========解密后数据==========");
            System.out.println(s);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
         */

        String string = "/access/sandbox/v2/invoke/203067/PLFPXZSQ/";
        String[] strArray = string.split("/");
        System.out.println(strArray[strArray.length - 1]);
    }


}


//
//
//class TestNsr {
//    private String nsrsbh;
//
//    public Integer getLysl() {
//        return lysl;
//    }
//
//    public void setLysl(Integer lysl) {
//        this.lysl = lysl;
//    }
//
//    private Integer lysl;
//
//    public String getNsrsbh() {
//        return nsrsbh;
//    }
//
//    public void setNsrsbh(String nsrsbh) {
//        this.nsrsbh = nsrsbh;
//    }
//}