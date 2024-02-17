package bank.zlbp.util;

/**
 * @author jiaoxian
 * @name bank.zlbp.util
 * @date 2023/12/13 17:10
 * @description TODO
 */

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
public class StringUtils {

    private static String newString(byte[] bytes, Charset charset) {
        return (bytes == null) ? null : new String(bytes, charset);
    }
    public static String newStringUtf8(byte[] bytes) {
        return newString(bytes, Charsets.UTF_8);
    }

    public static byte[] getBytesUtf8(String string) {
        return getBytes(string, Charsets.UTF_8);
    }

    private static byte[] getBytes(String string, Charset charset) {
        if (string == null) {
            return null;
        }
        return string.getBytes(charset);
    }

}
