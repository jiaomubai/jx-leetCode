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
        put("阿联酋迪拉姆", "AED");
        put("阿根廷比索", "ARS");
        put("奥地利先令", "ATS");
        put("澳大利亚元", "AUD");
        put("孟加拉塔卡", "BDT");
        put("比利时法郎", "BEF");
        put("巴林第纳尔", "BHD");
        put("汶莱元", "BND");
        put("巴西里亚伊（雷亚尔）", "BRL");
        put("巴克币", "BUK");
        put("博茨瓦纳普拉", "BWP");
        put("加拿大元", "CAD");
        put("瑞士法郎", "CHF");
        put("智利比索", "CLP");
        put("离岸人民币", "CNH");
        put("人民币", "CNY");
        put("德国马克", "DEM");
        put("丹麦克朗", "DKK");
        put("埃及镑", "EGP");
        put("西班牙比塞塔", "ESP");
        put("欧元", "EUR");
        put("芬兰马克", "FIM");
        put("法国法郎", "FRF");
        put("英镑", "GBP");
        put("加纳", "GHC");
        put("希腊德拉克马", "GRD");
        put("港币", "HKD");
        put("匈牙利福林", "HUF");
        put("印尼盾", "IDR");
        put("爱尔兰镑", "IEP");
        put("印度卢比", "INR");
        put("伊拉克第纳尔", "IQD");
        put("意大利里拉", "ITL");
        put("约旦第纳尔", "JOD");
        put("日元", "JPY");
        put("柬埔寨利尔斯", "KHR");
        put("韩国元", "KRW");
        put("科威特第纳尔", "KWD");
        put("哈萨克斯坦腾格", "KZT");
        put("老挝基普", "LAK");
        put("黎巴嫩镑", "LBP");
        put("斯里兰卡卢比", "LKR");
        put("缅甸元", "MMK");
        put("蒙古图格里克", "MNT");
        put("澳门元（澳门币）", "MOP");
        put("希腊德拉克马", "MTP");
        put("墨西哥比索", "MXN");
        put("马来西亚林吉特", "MYR");
        put("荷兰盾", "NLG");
        put("挪威克朗", "NOK");
        put("新西兰元", "NZD");
        put("菲律宾比索", "PHP");
        put("巴基斯坦卢比", "PKR");
        put("葡萄牙埃斯库多", "PTE");
        put("卡塔尔里亚尔", "QAR");
        put("罗马尼亚列伊", "RON");
        put("俄罗斯卢布", "RUB");
        put("所罗门群岛元", "SBD");
        put("塞舌尔卢比", "SCR");
        put("瑞典克朗", "SEK");
        put("新加坡元", "SGD");
        put("叙利亚镑", "SYP");
        put("泰铢", "THB");
        put("土耳其里拉", "TRY");
        put("新台币", "TWD");
        put("乌克兰赫夫米", "UAH");
        put("美元", "USD");
        put("委内瑞拉玻利瓦尔", "VEB");
        put("越南盾", "VND");
        put("银", "XAG");
        put("金", "XAU");
        put("铂", "XPT");
        put("也门第纳尔", "YDD");
        put("南非兰特", "ZAR");
        put("赞比亚克瓦查", "ZMW");
    }};

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    private static final String ENCODING = "UTF-8";
    public static final String ALGORITHM_NAME = "SM4";
    // 加密算法/分组加密模式/分组填充方式
    // PKCS5Padding-以8个字节为一组进行分组加密
    // 定义分组加密模式使用：PKCS5Padding
    public static final String ALGORITHM_NAME_ECB_PADDING = "SM4/ECB/PKCS5Padding";
    // 128-32位16进制；256-64位16进制
    public static final int DEFAULT_KEY_SIZE = 128;

    /**
     * 自动生成密钥
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
     * 生成ECB暗号
     *
     * @param algorithmName 算法名称
     * @param mode          模式
     * @param key
     * @return
     * @throws Exception
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
     * @return 返回16进制的加密字符串
     * @explain 加密模式：ECB
     * 密文长度不固定，会随着被加密字符串长度的变化而变化
     */
    public static String encryptEcb(String hexKey, String paramStr) {
        try {
            String cipherText = "";
            // 16进制字符串-->byte[]
            byte[] keyData = ByteUtils.fromHexString(hexKey);
            // String-->byte[]
            byte[] srcData = paramStr.getBytes(ENCODING);
            // 加密后的数组
            byte[] cipherArray = encrypt_Ecb_Padding(keyData, srcData);
            // byte[]-->hexString
            cipherText = ByteUtils.toHexString(cipherArray);
            return cipherText;
        } catch (Exception e) {
            return paramStr;
        }
    }

    /**
     * sm4加密
     *
     * @param hexKey   16进制密钥（忽略大小写）
     * @param paramStr 待加密字符串
     * @return 返回16进制的加密字符串
     * @explain 加密模式：ECB
     * 密文长度不固定，会随着被加密字符串长度的变化而变化
     */
    public static String encryptEcb(byte[] hexKey, String paramStr) {
        try {
            String cipherText = "";
            // 16进制字符串-->byte[]
            byte[] keyData = hexKey;
            // String-->byte[]
            byte[] srcData = paramStr.getBytes(ENCODING);
            // 加密后的数组
            byte[] cipherArray = encrypt_Ecb_Padding(keyData, srcData);
            // byte[]-->hexString
            cipherText = ByteUtils.toHexString(cipherArray);
            return cipherText;
        } catch (Exception e) {
            return paramStr;
        }
    }

    /**
     * 加密模式之Ecb
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
     * sm4解密
     *
     * @param hexKey     16进制密钥
     * @param cipherText 16进制的加密字符串（忽略大小写）
     * @return 解密后的字符串
     * @throws Exception
     * @explain 解密模式：采用ECB
     */
    public static String decryptEcb(String hexKey, String cipherText) {
        // 用于接收解密后的字符串
        String decryptStr = "";
        // hexString-->byte[]
        byte[] keyData = ByteUtils.fromHexString(hexKey);
        // hexString-->byte[]
        byte[] cipherData = ByteUtils.fromHexString(cipherText);
        // 解密
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
     * 解密
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
     * 校验加密前后的字符串是否为同一数据
     *
     * @param hexKey     16进制密钥（忽略大小写）
     * @param cipherText 16进制加密后的字符串
     * @param paramStr   加密前的字符串
     * @return 是否为同一数据
     * @throws Exception
     * @explain
     */
    public static boolean verifyEcb(String hexKey, String cipherText, String paramStr) throws Exception {
        // 用于接收校验结果
        boolean flag = false;
        // hexString-->byte[]
        byte[] keyData = ByteUtils.fromHexString(hexKey);
        // 将16进制字符串转换成数组
        byte[] cipherData = ByteUtils.fromHexString(cipherText);
        // 解密
        byte[] decryptData = decrypt_Ecb_Padding(keyData, cipherData);
        // 将原字符串转换成byte[]
        byte[] srcData = paramStr.getBytes(ENCODING);
        // 判断2个数组是否一致
        flag = Arrays.equals(decryptData, srcData);
        return flag;
    }

    /**
     * 字符串转16进制
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

        String fileMd5 = DigestUtils.md5Hex("C:\\Users\\Admin\\Desktop\\乱七八糟\\流动资金借款合同（2021年版）.docx");
        System.out.println("fileMd5:" + fileMd5);

        //String data1 = "<?xml version=\"1.0\" encoding=\"GBK\"?><Iss_Itreasury><QueryRen><OperationType>3</OperationType><RenContent><TransNo>Te65ffc76ee8569b341bea307f8b5fb94</TransNo><ExcutDate>2023-12-18 11:18:00.0</ExcutDate><AccountNo>37050171614100001142</AccountNo><AccountName></AccountName><CheckSign></CheckSign><OppAccountNo>CN000370AP0109P231218111322313260sd</OppAccountNo><OppAccountName>批量账务集中处理</OppAccountName><Note>代付转账19150.00元</Note><Abstract></Abstract><ApplyCode></ApplyCode><InterestStart>2023-12-18</InterestStart><TransDirection>1</TransDirection><Amount>19150.00</Amount><Balance></Balance><Currency>USD</Currency></RenContent><RenContent><TransNo>T881e4f2f1296c6f3925c2c2c34b1c7be</TransNo><ExcutDate>2023-12-18 10:28:01.0</ExcutDate><AccountNo>37050171614100001142</AccountNo><AccountName></AccountName><CheckSign></CheckSign><OppAccountNo>CN000370AP0118P231218102427307888sd</OppAccountNo><OppAccountName>批量账务集中处理</OppAccountName><Note>批量代收代付资金转回</Note><Abstract></Abstract><ApplyCode></ApplyCode><InterestStart>2023-12-18</InterestStart><TransDirection>2</TransDirection><Amount>19150.00</Amount><Balance></Balance><Currency>CNY</Currency></RenContent><RenContent><TransNo>T5df3416d3cdc1ed830f776c8beaf5038</TransNo><ExcutDate>2023-12-18 10:28:00.0</ExcutDate><AccountNo>37050171614100001142</AccountNo><AccountName></AccountName><CheckSign></CheckSign><OppAccountNo>CN000370AP0118P231218102427307888sd</OppAccountNo><OppAccountName>批量账务集中处理</OppAccountName><Note>代付转账38650.00元</Note><Abstract></Abstract><ApplyCode></ApplyCode><InterestStart>2023-12-18</InterestStart><TransDirection>1</TransDirection><Amount>38650.00</Amount><Balance></Balance><Currency>CNY</Currency></RenContent></QueryRen></Iss_Itreasury>";
        String data1 = "<?xml version=\"1.0\" encoding=\"GBK\"?><Iss_Itreasury><QueryRen><OperationType>17</OperationType><RenContent><Transdate>2021-09-09</Transdate><TransNo>20212520250018</TransNo><TransactionType>资金管理</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>中国工程与农业机械进出口有限公司</PayAccountName><DirectionStr></DirectionStr><Currency>美元</Currency><Amount>113,210.1700</Amount><ReceiveaccountNo>601250749201</ReceiveaccountNo><ReceiveaccountName>BRAMS PTE LTD</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>一般贸易货款牛肉</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-09</Transdate><TransNo>20212520250008</TransNo><TransactionType>资金管理</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>中国工程与农业机械进出口有限公司</PayAccountName><DirectionStr></DirectionStr><Currency>美元</Currency><Amount>124,193.0000</Amount><ReceiveaccountNo>00154825900001</ReceiveaccountNo><ReceiveaccountName>FRIGORIFICO SAN JACINTO-NIREA S.A</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>一般贸易货款牛肉</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-24</Transdate><TransNo>20212670250005</TransNo><TransactionType>资金管理</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>中国工程与农业机械进出口有限公司</PayAccountName><DirectionStr></DirectionStr><Currency>美元</Currency><Amount>102,870.0000</Amount><ReceiveaccountNo>601250749201</ReceiveaccountNo><ReceiveaccountName>BRAMS PTE LTD</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>一般贸易货款牛肉</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-28</Transdate><TransNo>20212710250023</TransNo><TransactionType>资金管理</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>中国工程与农业机械进出口有限公司</PayAccountName><DirectionStr></DirectionStr><Currency>美元</Currency><Amount>372,000.0000</Amount><ReceiveaccountNo>012-878-2-007805-3</ReceiveaccountNo><ReceiveaccountName>HONG KONG HUANGSHI BROTHERS WOOD INDUSTRY CO.,LTD</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>一般贸易货款木材</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-27</Transdate><TransNo>20212700250025</TransNo><TransactionType>资金管理</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>中国工程与农业机械进出口有限公司</PayAccountName><DirectionStr></DirectionStr><Currency>美元</Currency><Amount>188,882.9000</Amount><ReceiveaccountNo>3003-51227-7</ReceiveaccountNo><ReceiveaccountName>COMPANIA BERNAL S.A</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>一般贸易货款牛肉</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-27</Transdate><TransNo>20212700250023</TransNo><TransactionType>资金管理</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>中国工程与农业机械进出口有限公司</PayAccountName><DirectionStr></DirectionStr><Currency>美元</Currency><Amount>125,612.8500</Amount><ReceiveaccountNo>601250749201</ReceiveaccountNo><ReceiveaccountName>BRAMS PTE LTD</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>一般贸易货款牛肉</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-27</Transdate><TransNo>20212700250021</TransNo><TransactionType>资金管理</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>中国工程与农业机械进出口有限公司</PayAccountName><DirectionStr></DirectionStr><Currency>美元</Currency><Amount>104,895.0000</Amount><ReceiveaccountNo>601250749201</ReceiveaccountNo><ReceiveaccountName>BRAMS PTE LTD</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>一般贸易货款牛肉</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-08</Transdate><TransNo>20212510250013</TransNo><TransactionType>资金管理</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>中国工程与农业机械进出口有限公司</PayAccountName><DirectionStr></DirectionStr><Currency>美元</Currency><Amount>42,930.0000</Amount><ReceiveaccountNo>601250749201</ReceiveaccountNo><ReceiveaccountName>BRAMS PTE LTD</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>一般贸易货款牛肉</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-24</Transdate><TransNo>20212670250033</TransNo><TransactionType>资金管理</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>中国工程与农业机械进出口有限公司</PayAccountName><DirectionStr></DirectionStr><Currency>美元</Currency><Amount>52,065.0000</Amount><ReceiveaccountNo>846/2 SUC. 297</ReceiveaccountNo><ReceiveaccountName>ARRE BEEF S.A.</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>一般贸易货款牛肉</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-24</Transdate><TransNo>20212670250029</TransNo><TransactionType>资金管理</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>中国工程与农业机械进出口有限公司</PayAccountName><DirectionStr></DirectionStr><Currency>美元</Currency><Amount>230,283.7300</Amount><ReceiveaccountNo>601250749201</ReceiveaccountNo><ReceiveaccountName>BRAMS PTE LTD</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>一般贸易货款牛肉</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-14</Transdate><TransNo>20212570250014</TransNo><TransactionType>资金管理</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>中国工程与农业机械进出口有限公司</PayAccountName><DirectionStr></DirectionStr><Currency>美元</Currency><Amount>64,800.0000</Amount><ReceiveaccountNo>601250749201</ReceiveaccountNo><ReceiveaccountName>BRAMS PTE LTD</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>一般贸易货款牛肉</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-14</Transdate><TransNo>20212570250008</TransNo><TransactionType>资金管理</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>中国工程与农业机械进出口有限公司</PayAccountName><DirectionStr></DirectionStr><Currency>美元</Currency><Amount>493,864.4000</Amount><ReceiveaccountNo>601250749201</ReceiveaccountNo><ReceiveaccountName>BRAMS PTE LTD</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>一般贸易货款牛肉</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-01</Transdate><TransNo>20212440250024</TransNo><TransactionType>资金管理</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>中国工程与农业机械进出口有限公司</PayAccountName><DirectionStr></DirectionStr><Currency>美元</Currency><Amount>53,865.0000</Amount><ReceiveaccountNo>601250749201</ReceiveaccountNo><ReceiveaccountName>BRAMS PTE LTD</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>一般贸易货款牛肉</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-01</Transdate><TransNo>20212440250022</TransNo><TransactionType>资金管理</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>中国工程与农业机械进出口有限公司</PayAccountName><DirectionStr></DirectionStr><Currency>美元</Currency><Amount>686,861.4500</Amount><ReceiveaccountNo>601250749201</ReceiveaccountNo><ReceiveaccountName>BRAMS PTE LTD</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>一般贸易货款牛肉</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-08</Transdate><TransNo>20212510250015</TransNo><TransactionType>资金管理</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>中国工程与农业机械进出口有限公司</PayAccountName><DirectionStr></DirectionStr><Currency>美元</Currency><Amount>92,080.9200</Amount><ReceiveaccountNo>846/2 SUC. 297</ReceiveaccountNo><ReceiveaccountName>ARRE BEEF S.A. </ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>一般贸易货款牛肉</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent><RenContent><Transdate>2021-09-16</Transdate><TransNo>20212590250013</TransNo><TransactionType>资金管理</TransactionType><SubbusinessTypeidStr></SubbusinessTypeidStr><PayAccountNo>02-01-21-1-01-0005-01</PayAccountNo><PayAccountName>中国工程与农业机械进出口有限公司</PayAccountName><DirectionStr></DirectionStr><Currency>美元</Currency><Amount>39,091.5000</Amount><ReceiveaccountNo>IT11T0503466440000000002712</ReceiveaccountNo><ReceiveaccountName>COMER INDUSTRIES SPA</ReceiveaccountName><ReceiveopenBankNo>01-0194</ReceiveopenBankNo><StatusStr></StatusStr><Remarks>一般贸易货款聚乙烯</Remarks><ContractNo></ContractNo><StartDate></StartDate><EndDate></EndDate></RenContent></QueryRen></Iss_Itreasury>";
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
//        System.out.println("原始列表：" + listJson);
//        System.out.println("过滤后的列表：" + filteredNumbers);

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
        String data = "{\"requestHead\":{\"requestSeqNo\":\"23122211300201738039239611777024\",\"serviceCode\":\"SyncEmployees\",\"accountId\":\"2308251725279650c0500233977\",\"sign\":\"62db92e428fd0bb4e6daf14e1a448de0951edce6\",\"requestTime\":\"1703215820618\"},\"requestBody\":{\"record\":[{\"departCode\":\"1001A110000000016FS2\",\"departName\":\"虚拟部门\",\"gender\":null,\"userId\":\"0001A11000000002PYH8\",\"userName\":\"朱雨\",\"sequence\":\"1275207\",\"password\":null,\"lastName\":null,\"firstName\":null,\"country\":null,\"birthDay\":null,\"phone\":\"18649816070\",\"email\":\"\",\"address\":null,\"status\":\"1\",\"rank\":\"4\",\"rankName\":\"4\",\"operType\":null,\"subAccountName\":\"\",\"orgs\":[],\"bankCardInfo\":[],\"userCert\":[{\"idType\":\"0\",\"idNumber\":\"510902199512096070\",\"validDate\":null}],\"bigCusChannel\":[]}]}}";
        String miwen = encryptEcb(key, data);
        System.out.println("miwen:" + miwen);

        String mingwen = decryptEcb(key, "n0jP+hn6FIZSXxTbcKX1YqWXuYVQwE3FRbn7zButizH4Ror5Y1LupD8ZqhOZzBgguFSNNheQF1BQSqETZrGf8P+TyqAyJ8xB7vIBTXUyL0ongxm36ZW+pYTG7ah9PpYEoxYkmA1scmNFi8bqgf58ZsD11GlzehJ8vSZ7BXbmTyCp2dOSnjzebOwh/HIzN/GYzpUbm8JmzOzV/rWxsdQSiOEbgfH86Bs0B0MC13HQbIujAmH1Pcd7Q2QpNj/FNVvVbw77XM5l75a2O3DV7W0uPnzuc2zTXIztn5X8cgc10KPNWCcU75m1l7nCGygJM8q2tW9eK152m64K2tbmJYndIvZOqwhtOTZZHbPKxZR6Tew0NY2zfUYU0xeKzIhUzo7clffzZQJ3O5NrVfJzckiBqZUHEVAntwM+bZcoH3jKBHnqxv0Y2WKh+KSz2kNk6l+6FPOX0QQZ9Ug4VfA2KYMpvZuP2RSqLWsmyPbFvbyFN6GbzgNToj1k/umT58RpQzoake80rhIzcdZMLvmmaSCTaNbRGdMHshlQoSjxbOvbPg7Pc2kyiPSoDwGBxvEATsfoyMIhZXCL0XwYCH3zq3I8I8GKRsavLQdvWaMIszpviazxm1UmMyXSdsqjESLwqzMizpzqSdEHy8LRBRHGVemeEU/Z/TGJ3aZO7ns7syeEKBLLzQ1/9Z2lGKlVlI6zynbpDnouqc3COPkF9++RYdpKKrwjSv799EPHS4O217KEwshX0ZmJOSnc+jhKPv0EU4n8bECwsqdUYlOEtV0Q5T0ZxDcfzmYYM/GhHvh8MLcqbTuaQFg/gKxb0D4FRZqGLZhgbZUCqlW4+fzJwicKURv9XwnYGqfF8QhARFuOp0EAebbgMicvfzFbP6yfpumcq5KuIIYnrs6gSr4MBsTzvMYlAhhuDp41uosqfEcgx9Vyjg8HnQyK+dhB8W/GwMZCUb63haoCafLR4TRjMWrNQxIkHg==");
        System.out.println("mingwen:" + mingwen);

        System.out.println("密钥:" + generateKey());





    }

}
