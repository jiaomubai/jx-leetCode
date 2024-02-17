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
    // �����㷨/�������ģʽ/������䷽ʽ
    // PKCS5Padding-��8���ֽ�Ϊһ����з������
    // ����������ģʽʹ�ã�PKCS5Padding
    public static final String ALGORITHM_NAME_ECB_PADDING = "SM4/ECB/PKCS5Padding";


    /**
     * ����ECB����
     *
     * @param algorithmName �㷨����
     * @param mode          ģʽ
     * @param key           ����
     * @explain ECBģʽ���������뱾ģʽ��Electronic codebook��
     */
    private static Cipher generateEcbCipher(String algorithmName, int mode, byte[] key) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithmName, BouncyCastleProvider.PROVIDER_NAME);
        Key sm4Key = new SecretKeySpec(key, ALGORITHM_NAME);
        cipher.init(mode, sm4Key);
        return cipher;
    }

    /**
     * sm4����
     *
     * @param hexKey   16������Կ�����Դ�Сд��
     * @param paramStr �������ַ���
     * @return ����Base64������ַ���
     * @explain ����ģʽ��ECB
     */
    public static String encryptEcb(String hexKey, String paramStr) throws Exception {
        // 16�����ַ���-->byte[]
        byte[] keyData = ByteUtils.fromHexString(hexKey);
        // String-->byte[]
        byte[] srcData = paramStr.getBytes(ENCODING);
        // ���ܺ������
        byte[] cipherArray = encrypt_Ecb_Padding(keyData, srcData);
        // byte[]-->hexString
        String cipherText = Base64.getEncoder().encodeToString(cipherArray);
        return cipherText;
    }

    /**
     * ����ģʽΪECB
     *
     * @param key  2������Կ
     * @param data 2����ԭ��
     * @return ����������
     */
    public static byte[] encrypt_Ecb_Padding(byte[] key, byte[] data) throws Exception {
        Cipher cipher = generateEcbCipher(ALGORITHM_NAME_ECB_PADDING, Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    /**
     * sm4����
     *
     * @param hexKey     16������Կ
     * @param cipherText 16���Ƶļ����ַ��������Դ�Сд��
     * @return ���ܺ���ַ���
     * @explain ����ģʽ������ECB
     */
    @SuppressWarnings("UnnecessaryLocalVariable")
    public static String decryptEcb(String hexKey, String cipherText) throws Exception {
        // hexString-->byte[]
        byte[] keyData = ByteUtils.fromHexString(hexKey);
        // hexString-->byte[]
        byte[] cipherData = Base64.getDecoder().decode(cipherText);
        // ����
        byte[] srcData = decrypt_Ecb_Padding(keyData, cipherData);
        // ���ս��ܺ���ַ��� byte[]-->String
        String decryptStr = new String(srcData, ENCODING);
        return decryptStr;
    }

    /**
     * sm4����
     *
     * @param key  2������Կ
     * @param cipherText 2��������
     * @return ���ܺ��2����ԭ��
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

//            String paramStr = "����ԭ�� original text";
            System.out.println("==========����ǰԴ����==========");
            System.out.println(s);
            // ����32λ16������Կ
//            String key = LeQi2.generateKey();
//            System.out.println("==========����key==========");
//            System.out.println(key);
            String key = "eed467ac3b21eb08248653dc33bbfe84";
            String cipher = LeQi2.encryptEcb(key, s);
            System.out.println("==========���ܴ�==========");
            System.out.println(cipher);
            System.out.println("==========�Ƿ�Ϊͬһ����==========");
//            System.out.println(LeQi2.verifyEcb(key, cipher, s));
            s = LeQi2.decryptEcb(key, cipher);
            System.out.println("==========���ܺ�����==========");
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