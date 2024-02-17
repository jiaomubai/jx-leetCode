package bank.leqi;

import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.SecureRandom;
import java.security.Security;
import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


/**
 * @author jiaoxian
 * @name bank.leqi
 * @date 2023/11/7 7:01
 * @description TODO
 */
public class LeQi {

    private final static HashMap<String, String> currencyMap = new HashMap<String, String>() {{
        put("����������ķ", "AED");
        put("����͢����", "ARS");
        put("�µ�������", "ATS");
        put("�Ĵ�����Ԫ", "AUD");
        put("�ϼ�������", "BDT");
        put("����ʱ����", "BEF");
        put("���ֵ��ɶ�", "BHD");
        put("����Ԫ", "BND");
        put("���������������Ƕ���", "BRL");
        put("�Ϳ˱�", "BUK");
        put("������������", "BWP");
        put("���ô�Ԫ", "CAD");
        put("��ʿ����", "CHF");
        put("��������", "CLP");
        put("�밶�����", "CNH");
        put("�����", "CNY");
        put("�¹����", "DEM");
        put("�������", "DKK");
        put("������", "EGP");
        put("������������", "ESP");
        put("ŷԪ", "EUR");
        put("�������", "FIM");
        put("��������", "FRF");
        put("Ӣ��", "GBP");
        put("����", "GHC");
        put("ϣ����������", "GRD");
        put("�۱�", "HKD");
        put("����������", "HUF");
        put("ӡ���", "IDR");
        put("��������", "IEP");
        put("ӡ��¬��", "INR");
        put("�����˵��ɶ�", "IQD");
        put("���������", "ITL");
        put("Լ�����ɶ�", "JOD");
        put("��Ԫ", "JPY");
        put("����կ����˹", "KHR");
        put("����Ԫ", "KRW");
        put("�����ص��ɶ�", "KWD");
        put("������˹̹�ڸ�", "KZT");
        put("���λ���", "LAK");
        put("����۰�", "LBP");
        put("˹������¬��", "LKR");
        put("���Ԫ", "MMK");
        put("�ɹ�ͼ�����", "MNT");
        put("����Ԫ�����űң�", "MOP");
        put("ϣ����������", "MTP");
        put("ī�������", "MXN");
        put("���������ּ���", "MYR");
        put("������", "NLG");
        put("Ų������", "NOK");
        put("������Ԫ", "NZD");
        put("���ɱ�����", "PHP");
        put("�ͻ�˹̹¬��", "PKR");
        put("��������˹���", "PTE");
        put("���������Ƕ�", "QAR");
        put("������������", "RON");
        put("����˹¬��", "RUB");
        put("������Ⱥ��Ԫ", "SBD");
        put("�����¬��", "SCR");
        put("������", "SEK");
        put("�¼���Ԫ", "SGD");
        put("�����ǰ�", "SYP");
        put("̩��", "THB");
        put("����������", "TRY");
        put("��̨��", "TWD");
        put("�ڿ����շ���", "UAH");
        put("��Ԫ", "USD");
        put("ί�����������߶�", "VEB");
        put("Խ�϶�", "VND");
        put("��", "XAG");
        put("��", "XAU");
        put("��", "XPT");
        put("Ҳ�ŵ��ɶ�", "YDD");
        put("�Ϸ�����", "ZAR");
        put("�ޱ��ǿ��߲�", "ZMW");
    }};

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
        return new String(Hex.encodeHex(generateKey(DEFAULT_KEY_SIZE),false));
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
            byte[] cipherArray = encrypt_Ecb_Padding(keyData, srcData);
            // byte[]-->hexString
            cipherText = ByteUtils.toHexString(cipherArray);
            return cipherText;
        } catch (Exception e) {
            return paramStr;
        }
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
    public static String encryptEcb(byte[] hexKey, String paramStr) {
        try {
            String cipherText = "";
            // 16�����ַ���-->byte[]
            byte[] keyData = hexKey;
            // String-->byte[]
            byte[] srcData = paramStr.getBytes(ENCODING);
            // ���ܺ������
            byte[] cipherArray = encrypt_Ecb_Padding(keyData, srcData);
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
            srcData = decrypt_Ecb_Padding(keyData, cipherData);
            // byte[]-->String
            decryptStr = new String(srcData, ENCODING);
        } catch (Exception e) {
            //log.error(ExceptionUtil.getMessage(e));
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
    public static byte[] decrypt_Ecb_Padding(byte[] key, byte[] cipherText) throws Exception {
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
        byte[] decryptData = decrypt_Ecb_Padding(keyData, cipherData);
        // ��ԭ�ַ���ת����byte[]
        byte[] srcData = paramStr.getBytes(ENCODING);
        // �ж�2�������Ƿ�һ��
        flag = Arrays.equals(decryptData, srcData);
        return flag;
    }

    /**
     * �ַ���ת16����
     * @param hex
     * @return
     */
    public static byte[] hex2byte(String hex) {

        String digital = "0123456789ABCDEF";
        String hex1 = hex.replace(" ", "");
        char[] hex2char = hex1.toCharArray();
        byte[] bytes = new byte[hex1.length() / 2];
        byte temp;
        for (int p = 0; p < bytes.length; p++) {
            temp = (byte) (digital.indexOf(hex2char[2 * p]) * 16);
            temp += digital.indexOf(hex2char[2 * p + 1]);
            bytes[p] = (byte) (temp & 0xff);
        }
        return bytes;
    }


    public static void main(String[] args) throws Exception {

        String fileMd5 = DigestUtils.md5Hex("C:\\Users\\Admin\\Desktop\\���߰���\\�����ʽ����ͬ��2021��棩.docx");
        System.out.println("fileMd5:" + fileMd5);

        //String data1 = "<?xml version=\"1.0\" encoding=\"GBK\"?><Iss_Itreasury><QueryRen><OperationType>3</OperationType><RenContent><TransNo>Te65ffc76ee8569b341bea307f8b5fb94</TransNo><ExcutDate>2023-12-18 11:18:00.0</ExcutDate><AccountNo>37050171614100001142</AccountNo><AccountName></AccountName><CheckSign></CheckSign><OppAccountNo>CN000370AP0109P231218111322313260sd</OppAccountNo><OppAccountName>���������д���</OppAccountName><Note>����ת��19150.00Ԫ</Note><Abstract></Abstract><ApplyCode></ApplyCode><InterestStart>2023-12-18</InterestStart><TransDirection>1</TransDirection><Amount>19150.00</Amount><Balance></Balance><Currency>USD</Currency></RenContent><RenContent><TransNo>T881e4f2f1296c6f3925c2c2c34b1c7be</TransNo><ExcutDate>2023-12-18 10:28:01.0</ExcutDate><AccountNo>37050171614100001142</AccountNo><AccountName></AccountName><CheckSign></CheckSign><OppAccountNo>CN000370AP0118P231218102427307888sd</OppAccountNo><OppAccountName>���������д���</OppAccountName><Note>�������մ����ʽ�ת��</Note><Abstract></Abstract><ApplyCode></ApplyCode><InterestStart>2023-12-18</InterestStart><TransDirection>2</TransDirection><Amount>19150.00</Amount><Balance></Balance><Currency>CNY</Currency></RenContent><RenContent><TransNo>T5df3416d3cdc1ed830f776c8beaf5038</TransNo><ExcutDate>2023-12-18 10:28:00.0</ExcutDate><AccountNo>37050171614100001142</AccountNo><AccountName></AccountName><CheckSign></CheckSign><OppAccountNo>CN000370AP0118P231218102427307888sd</OppAccountNo><OppAccountName>���������д���</OppAccountName><Note>����ת��38650.00Ԫ</Note><Abstract></Abstract><ApplyCode></ApplyCode><InterestStart>2023-12-18</InterestStart><TransDirection>1</TransDirection><Amount>38650.00</Amount><Balance></Balance><Currency>CNY</Currency></RenContent></QueryRen></Iss_Itreasury>";
        String data1 = "<?xml version=\"1.0\" encoding=\"GBK\"?><Iss_Itreasury><QueryRen><OperationType>17</OperationType><RenContent><Transdate>2021-09-09</Transdate><TransNo>20212520250018</TransNo><TransactionType>�ʽ����</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>�й�������ũҵ��е���������޹�˾</PayAccountName><DirectionStr></DirectionStr><Currency>��Ԫ</Currency><Amount>113,210.1700</Amount><ReceiveaccountNo>601250749201</ReceiveaccountNo><ReceiveaccountName>BRAMS PTE LTD</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>һ��ó�׻���ţ��</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-09</Transdate><TransNo>20212520250008</TransNo><TransactionType>�ʽ����</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>�й�������ũҵ��е���������޹�˾</PayAccountName><DirectionStr></DirectionStr><Currency>��Ԫ</Currency><Amount>124,193.0000</Amount><ReceiveaccountNo>00154825900001</ReceiveaccountNo><ReceiveaccountName>FRIGORIFICO SAN JACINTO-NIREA S.A</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>һ��ó�׻���ţ��</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-24</Transdate><TransNo>20212670250005</TransNo><TransactionType>�ʽ����</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>�й�������ũҵ��е���������޹�˾</PayAccountName><DirectionStr></DirectionStr><Currency>��Ԫ</Currency><Amount>102,870.0000</Amount><ReceiveaccountNo>601250749201</ReceiveaccountNo><ReceiveaccountName>BRAMS PTE LTD</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>һ��ó�׻���ţ��</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-28</Transdate><TransNo>20212710250023</TransNo><TransactionType>�ʽ����</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>�й�������ũҵ��е���������޹�˾</PayAccountName><DirectionStr></DirectionStr><Currency>��Ԫ</Currency><Amount>372,000.0000</Amount><ReceiveaccountNo>012-878-2-007805-3</ReceiveaccountNo><ReceiveaccountName>HONG KONG HUANGSHI BROTHERS WOOD INDUSTRY CO.,LTD</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>һ��ó�׻���ľ��</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-27</Transdate><TransNo>20212700250025</TransNo><TransactionType>�ʽ����</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>�й�������ũҵ��е���������޹�˾</PayAccountName><DirectionStr></DirectionStr><Currency>��Ԫ</Currency><Amount>188,882.9000</Amount><ReceiveaccountNo>3003-51227-7</ReceiveaccountNo><ReceiveaccountName>COMPANIA BERNAL S.A</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>һ��ó�׻���ţ��</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-27</Transdate><TransNo>20212700250023</TransNo><TransactionType>�ʽ����</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>�й�������ũҵ��е���������޹�˾</PayAccountName><DirectionStr></DirectionStr><Currency>��Ԫ</Currency><Amount>125,612.8500</Amount><ReceiveaccountNo>601250749201</ReceiveaccountNo><ReceiveaccountName>BRAMS PTE LTD</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>һ��ó�׻���ţ��</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-27</Transdate><TransNo>20212700250021</TransNo><TransactionType>�ʽ����</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>�й�������ũҵ��е���������޹�˾</PayAccountName><DirectionStr></DirectionStr><Currency>��Ԫ</Currency><Amount>104,895.0000</Amount><ReceiveaccountNo>601250749201</ReceiveaccountNo><ReceiveaccountName>BRAMS PTE LTD</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>һ��ó�׻���ţ��</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-08</Transdate><TransNo>20212510250013</TransNo><TransactionType>�ʽ����</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>�й�������ũҵ��е���������޹�˾</PayAccountName><DirectionStr></DirectionStr><Currency>��Ԫ</Currency><Amount>42,930.0000</Amount><ReceiveaccountNo>601250749201</ReceiveaccountNo><ReceiveaccountName>BRAMS PTE LTD</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>һ��ó�׻���ţ��</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-24</Transdate><TransNo>20212670250033</TransNo><TransactionType>�ʽ����</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>�й�������ũҵ��е���������޹�˾</PayAccountName><DirectionStr></DirectionStr><Currency>��Ԫ</Currency><Amount>52,065.0000</Amount><ReceiveaccountNo>846/2 SUC. 297</ReceiveaccountNo><ReceiveaccountName>ARRE BEEF S.A.</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>һ��ó�׻���ţ��</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-24</Transdate><TransNo>20212670250029</TransNo><TransactionType>�ʽ����</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>�й�������ũҵ��е���������޹�˾</PayAccountName><DirectionStr></DirectionStr><Currency>��Ԫ</Currency><Amount>230,283.7300</Amount><ReceiveaccountNo>601250749201</ReceiveaccountNo><ReceiveaccountName>BRAMS PTE LTD</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>һ��ó�׻���ţ��</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-14</Transdate><TransNo>20212570250014</TransNo><TransactionType>�ʽ����</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>�й�������ũҵ��е���������޹�˾</PayAccountName><DirectionStr></DirectionStr><Currency>��Ԫ</Currency><Amount>64,800.0000</Amount><ReceiveaccountNo>601250749201</ReceiveaccountNo><ReceiveaccountName>BRAMS PTE LTD</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>һ��ó�׻���ţ��</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-14</Transdate><TransNo>20212570250008</TransNo><TransactionType>�ʽ����</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>�й�������ũҵ��е���������޹�˾</PayAccountName><DirectionStr></DirectionStr><Currency>��Ԫ</Currency><Amount>493,864.4000</Amount><ReceiveaccountNo>601250749201</ReceiveaccountNo><ReceiveaccountName>BRAMS PTE LTD</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>һ��ó�׻���ţ��</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-01</Transdate><TransNo>20212440250024</TransNo><TransactionType>�ʽ����</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>�й�������ũҵ��е���������޹�˾</PayAccountName><DirectionStr></DirectionStr><Currency>��Ԫ</Currency><Amount>53,865.0000</Amount><ReceiveaccountNo>601250749201</ReceiveaccountNo><ReceiveaccountName>BRAMS PTE LTD</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>һ��ó�׻���ţ��</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-01</Transdate><TransNo>20212440250022</TransNo><TransactionType>�ʽ����</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>�й�������ũҵ��е���������޹�˾</PayAccountName><DirectionStr></DirectionStr><Currency>��Ԫ</Currency><Amount>686,861.4500</Amount><ReceiveaccountNo>601250749201</ReceiveaccountNo><ReceiveaccountName>BRAMS PTE LTD</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>һ��ó�׻���ţ��</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-08</Transdate><TransNo>20212510250015</TransNo><TransactionType>�ʽ����</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>�й�������ũҵ��е���������޹�˾</PayAccountName><DirectionStr></DirectionStr><Currency>��Ԫ</Currency><Amount>92,080.9200</Amount><ReceiveaccountNo>846/2 SUC. 297</ReceiveaccountNo><ReceiveaccountName>ARRE BEEF S.A. </ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>һ��ó�׻���ţ��</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-16</Transdate><TransNo>20212590250013</TransNo><TransactionType>�ʽ����</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>�й�������ũҵ��е���������޹�˾</PayAccountName><DirectionStr></DirectionStr><Currency>��Ԫ</Currency><Amount>39,091.5000</Amount><ReceiveaccountNo>IT11T0503466440000000002712</ReceiveaccountNo><ReceiveaccountName>COMER INDUSTRIES SPA</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>һ��ó�׻������ϩ</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent></QueryRen></Iss_Itreasury>";
        String currCode = "CNY";
        String queryAcctNo = "02-01-21-1-01-0005-01";
        String data2 = data1.substring(data1.indexOf("<QueryRen>"), data1.lastIndexOf("</Iss_Itreasury>"));
        System.out.println("data2:" + data2);
        XmlMapper xmlMapper = new XmlMapper();
        List<Map<String, String>> listJson = xmlMapper.readValue(data2, List.class);
        for (int i = 0; i < listJson.size(); i++) {
            if (listJson.get(i) == null || !(listJson.get(i) instanceof java.util.Map)) {
                listJson.remove(i);
                break;
            }
        }
        System.out.println("size:" + listJson.size());

//        List<Map<String, String>> filteredNumbers = listJson.stream()
//                .filter(map -> map.get("Currency").equals("CNY"))
//                .collect(Collectors.toList());
//
//        System.out.println("ԭʼ�б�" + listJson);
//        System.out.println("���˺���б�" + filteredNumbers);

        List<Map<String, String>> newList = listJson.stream().filter(map -> map.get("PayAccountNo").equals(queryAcctNo) || map.get("ReceiveaccountNo").equals(queryAcctNo))
                .peek(map -> map.put("CurrencyNew", currencyMap.get(map.get("Currency"))))
                .collect(Collectors.toList());



        JsonNode jsonNode = xmlMapper.readTree(data2);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(jsonNode);



        System.out.println("JSON:" + json);



        Map<String, String> map1 = new HashMap<>();
        map1.put("A", "123");
        map1.put("B", "456");
        Map<String, String> map2 = new HashMap<>();
        map1.put("A", "");
        map1.put("B", "456");
        List<Map<String, String>> list = new ArrayList<>();
        list.add(map1);
        list.add(map2);
        System.out.println(list.size());
        for (int i = 0; i < 2; i++) {
            if (list.get(i).get("A") == null || list.get(i).get("A") == "") {
                list.remove(i);
            }

        }
        System.out.println(list.size());
        System.out.println();





        String str1 = "";
        URLDecoder urlDecoder = new URLDecoder();
        String str1New = urlDecoder.decode(str1);

//        LeQi leQi = new LeQi();
//
//        System.out.println(leQi.generateKey());


//        String key = "E61E2E5B8560E517B67CB069397B17DD";
        String key = null;
        Map requestDataMap = JSON.parseObject(key, Map.class);
        String key2 = key.replaceAll("X", "");
        System.out.println("key2:" + key2);
        String data = "{\"requestHead\":{\"requestSeqNo\":\"23122211300201738039239611777024\",\"serviceCode\":\"SyncEmployees\",\"accountId\":\"2308251725279650c0500233977\",\"sign\":\"62db92e428fd0bb4e6daf14e1a448de0951edce6\",\"requestTime\":\"1703215820618\"},\"requestBody\":{\"record\":[{\"departCode\":\"1001A110000000016FS2\",\"departName\":\"���ⲿ��\",\"gender\":null,\"userId\":\"0001A11000000002PYH8\",\"userName\":\"����\",\"sequence\":\"1275207\",\"password\":null,\"lastName\":null,\"firstName\":null,\"country\":null,\"birthDay\":null,\"phone\":\"18649816070\",\"email\":\"\",\"address\":null,\"status\":\"1\",\"rank\":\"4\",\"rankName\":\"4\",\"operType\":null,\"subAccountName\":\"\",\"orgs\":[],\"bankCardInfo\":[],\"userCert\":[{\"idType\":\"0\",\"idNumber\":\"510902199512096070\",\"validDate\":null}],\"bigCusChannel\":[]}]}}";
        String miwen = encryptEcb(key, data);
        System.out.println("miwen:" + miwen);

        String mingwen = decryptEcb(key, "n0jP+hn6FIZSXxTbcKX1YqWXuYVQwE3FRbn7zButizH4Ror5Y1LupD8ZqhOZzBgguFSNNheQF1BQSqETZrGf8P+TyqAyJ8xB7vIBTXUyL0ongxm36ZW+pYTG7ah9PpYEoxYkmA1scmNFi8bqgf58ZsD11GlzehJ8vSZ7BXbmTyCp2dOSnjzebOwh/HIzN/GYzpUbm8JmzOzV/rWxsdQSiOEbgfH86Bs0B0MC13HQbIujAmH1Pcd7Q2QpNj/FNVvVbw77XM5l75a2O3DV7W0uPnzuc2zTXIztn5X8cgc10KPNWCcU75m1l7nCGygJM8q2tW9eK152m64K2tbmJYndIvZOqwhtOTZZHbPKxZR6Tew0NY2zfUYU0xeKzIhUzo7clffzZQJ3O5NrVfJzckiBqZUHEVAntwM+bZcoH3jKBHnqxv0Y2WKh+KSz2kNk6l+6FPOX0QQZ9Ug4VfA2KYMpvZuP2RSqLWsmyPbFvbyFN6GbzgNToj1k/umT58RpQzoake80rhIzcdZMLvmmaSCTaNbRGdMHshlQoSjxbOvbPg7Pc2kyiPSoDwGBxvEATsfoyMIhZXCL0XwYCH3zq3I8I8GKRsavLQdvWaMIszpviazxm1UmMyXSdsqjESLwqzMizpzqSdEHy8LRBRHGVemeEU/Z/TGJ3aZO7ns7syeEKBLLzQ1/9Z2lGKlVlI6zynbpDnouqc3COPkF9++RYdpKKrwjSv799EPHS4O217KEwshX0ZmJOSnc+jhKPv0EU4n8bECwsqdUYlOEtV0Q5T0ZxDcfzmYYM/GhHvh8MLcqbTuaQFg/gKxb0D4FRZqGLZhgbZUCqlW4+fzJwicKURv9XwnYGqfF8QhARFuOp0EAebbgMicvfzFbP6yfpumcq5KuIIYnrs6gSr4MBsTzvMYlAhhuDp41uosqfEcgx9Vyjg8HnQyK+dhB8W/GwMZCUb63haoCafLR4TRjMWrNQxIkHg==");
        System.out.println("mingwen:" + mingwen);

        System.out.println("��Կ:" + generateKey());





    }

}
