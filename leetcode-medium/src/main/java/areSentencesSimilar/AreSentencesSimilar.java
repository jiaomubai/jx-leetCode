package areSentencesSimilar;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author jiaoxian
 * @name areSentencesSimilar
 * @date 2023/1/16 9:19
 * @description leetCode-1813: 句子相似性 III
 */
public class AreSentencesSimilar {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        int length1 = sentence1.length();
        int length2 = sentence2.length();
        return true;
    }

    public String getSign(TreeMap<String, String> treeMap, String secret) throws Exception {
        String sortedKvStr = treeMap.entrySet().stream().map(entry -> {
            try {
                return URLEncoder.encode(String.valueOf(entry.getKey()), "UTF-8") + "="
                        + URLEncoder.encode(String.valueOf(entry.getValue()), "UTF-8") + "&";
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }).reduce("", String::concat);

        sortedKvStr = sortedKvStr.substring(0, sortedKvStr.length() - 1) + secret;

        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(sortedKvStr.getBytes());
            byte[] byteResult = digest.digest();
            String result = convertbyte2String(byteResult);
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    private String convertbyte2String(byte[] byteResult) {

        char[] hexDigits = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F' };
        char[] result = new char[byteResult.length * 2];
        int index = 0;
        for (byte b : byteResult) {
            result[index++] = hexDigits[b >>> 4 & 0xF];
            result[index++] = hexDigits[b & 0xF];
        }
        return new String(result);
    }

    public TreeMap<String, String> sortMap(Map<String, String> map) throws Exception{
        TreeMap<String, String> treeMap = new TreeMap<>(map);
        System.out.println();
        String sign = getSign(treeMap, "3aefe70e045443168ac47b4ad1f67b99");
        System.out.println("sign = " + sign);
        return treeMap;
    }

    public static void main(String[] args) throws Exception{


    }

}
