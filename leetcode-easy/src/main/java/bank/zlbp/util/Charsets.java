package bank.zlbp.util;

/**
 * @author jiaoxian
 * @name bank.zlbp.util
 * @date 2023/12/13 17:11
 * @description TODO
 */

import java.nio.charset.Charset;

public class Charsets {

    public static Charset toCharset(Charset charset) {
        return (charset == null) ? Charset.defaultCharset() : charset;
    }

    public static Charset toCharset(String charset) {
        return (charset == null) ? Charset.defaultCharset() : Charset.forName(charset);
    }

    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    public static final Charset US_ASCII = Charset.forName("US-ASCII");

    public static final Charset UTF_16 = Charset.forName("UTF-16");

    public static final Charset UTF_16BE = Charset.forName("UTF-16BE");

    public static final Charset UTF_16LE = Charset.forName("UTF-16LE");

    public static final Charset UTF_8 = Charset.forName("UTF-8");

}
