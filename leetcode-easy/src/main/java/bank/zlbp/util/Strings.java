package bank.zlbp.util;

/**
 * @author jiaoxian
 * @name bank.zlbp.util
 * @date 2023/12/13 17:26
 * @description TODO
 */
public class Strings {

    public static String fromByteArray(byte[] paramArrayOfbyte) {
        return new String(asCharArray(paramArrayOfbyte));
    }

    public static char[] asCharArray(byte[] paramArrayOfbyte) {
        char[] arrayOfChar = new char[paramArrayOfbyte.length];
        for (byte b = 0; b != arrayOfChar.length; b++) {
            arrayOfChar[b] = (char)(paramArrayOfbyte[b] & 0xFF);
        }
        return arrayOfChar;
    }

}
