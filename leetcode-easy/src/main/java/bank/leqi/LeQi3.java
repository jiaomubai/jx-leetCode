package bank.leqi;

import com.alibaba.fastjson2.JSON;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;
import org.bouncycastle.util.encoders.Hex;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Arrays;

/**
 * @author jiaoxian
 * @name bank.leqi
 * @date 2023/11/7 8:39
 * @description TODO
 */
public class LeQi3 {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    private static final String ENCODING = "UTF-8";
    public static final String ALGORITHM_NAME = "SM4";
    // �����㷨/�������ģʽ/������䷽ʽ
    // PKCS5Padding-��8���ֽ�Ϊһ����з������
    // ����������ģʽʹ�ã�PKCS5Padding
    public static final String ALGORITHM_NAME_ECB_PADDING = "SM4/ECB/PKCS5Padding";
    // 128-32λ16���ƣ�256-64λ16����
    public static final int DEFAULT_KEY_SIZE = 128;

    /**
     * �Զ�������Կ
     *
     * @return
     * @explain
     */
    public static String generateKey() throws Exception {
        return new String(Hex.encode(generateKey(DEFAULT_KEY_SIZE)));
    }

    /**
     * @param keySize
     * @return
     * @throws Exception
     * @explain
     */
    public static byte[] generateKey(int keySize) throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance(ALGORITHM_NAME, BouncyCastleProvider.PROVIDER_NAME);
        kg.init(keySize, new SecureRandom());
        return kg.generateKey().getEncoded();
    }

    /**
     * ����ECB����
     *
     * @param algorithmName �㷨����
     * @param mode          ģʽ
     * @param key
     * @return
     * @throws Exception
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
     * @return ����16���Ƶļ����ַ���
     * @explain ����ģʽ��ECB
     * ���ĳ��Ȳ��̶��������ű������ַ������ȵı仯���仯
     */
    public static String encryptEcb(String hexKey, String paramStr) {
        try {
            String cipherText = "";
            // 16�����ַ���-->byte[]
            byte[] keyData = ByteUtils.fromHexString(hexKey);
            // String-->byte[]
            byte[] srcData = paramStr.getBytes(ENCODING);
            // ���ܺ������
            byte[] cipherArray = encryptEcbPadding(keyData, srcData);
            // byte[]-->hexString
            cipherText = ByteUtils.toHexString(cipherArray);
            return cipherText;
        } catch (Exception e) {
            return paramStr;
        }
    }

    /**
     * ����ģʽ֮Ecb
     *
     * @param key
     * @param data
     * @return
     * @throws Exception
     * @explain
     */
    private static byte[] encryptEcbPadding(byte[] key, byte[] data) throws Exception {
        Cipher cipher = generateEcbCipher(ALGORITHM_NAME_ECB_PADDING, Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    /**
     * sm4����
     *
     * @param hexKey     16������Կ
     * @param cipherText 16���Ƶļ����ַ��������Դ�Сд��
     * @return ���ܺ���ַ���
     * @throws Exception
     * @explain ����ģʽ������ECB
     */
    public static String decryptEcb(String hexKey, String cipherText) {
        // ���ڽ��ս��ܺ���ַ���
        String decryptStr = "";
        // hexString-->byte[]
        byte[] keyData = ByteUtils.fromHexString(hexKey);
        // hexString-->byte[]
        byte[] cipherData = ByteUtils.fromHexString(cipherText);
        // ����
        byte[] srcData = new byte[0];
        try {
            srcData = decryptEcbPadding(keyData, cipherData);
            // byte[]-->String
            decryptStr = new String(srcData, ENCODING);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptStr;
    }

    /**
     * ����
     *
     * @param key
     * @param cipherText
     * @return
     * @throws Exception
     * @explain
     */
    private static byte[] decryptEcbPadding(byte[] key, byte[] cipherText) throws Exception {
        Cipher cipher = generateEcbCipher(ALGORITHM_NAME_ECB_PADDING, Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(cipherText);
    }

    /**
     * У�����ǰ����ַ����Ƿ�Ϊͬһ����
     *
     * @param hexKey     16������Կ�����Դ�Сд��
     * @param cipherText 16���Ƽ��ܺ���ַ���
     * @param paramStr   ����ǰ���ַ���
     * @return �Ƿ�Ϊͬһ����
     * @throws Exception
     * @explain
     */
    public static boolean verifyEcb(String hexKey, String cipherText, String paramStr) throws Exception {
        // ���ڽ���У����
        boolean flag = false;
        // hexString-->byte[]
        byte[] keyData = ByteUtils.fromHexString(hexKey);
        // ��16�����ַ���ת��������
        byte[] cipherData = ByteUtils.fromHexString(cipherText);
        // ����
        byte[] decryptData = decryptEcbPadding(keyData, cipherData);
        // ��ԭ�ַ���ת����byte[]
        byte[] srcData = paramStr.getBytes(ENCODING);
        // �ж�2�������Ƿ�һ��
        flag = Arrays.equals(decryptData, srcData);
        return flag;
    }

    public static void main(String[] args) {

        try {
            FP028aReq fp028aReq = new FP028aReq();
            fp028aReq.setFplx("04");
            fp028aReq.setCljg("1");
            fp028aReq.setNsrsbh("91440700719259080H");
            fp028aReq.setPackagecount("1");



        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            String nsrsbh = "91440700719259080H";

//            A a = new A();
//            a.setNsrsbh(nsrsbh);
            String s = JSON.toJSON("").toString();
////            String paramStr = "{nsfrshb:91440700719259080H}";

            System.out.println(s);

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



}



