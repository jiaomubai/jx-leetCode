package bank.zlbp.util;

/**
 * @author jiaoxian
 * @name bank.zlbp.util
 * @date 2023/12/13 17:24
 * @description TODO
 */

import java.io.ByteArrayOutputStream;

public class Hex {

    private static final Encoder encoder = new HexEncoder();

    public static String toHexString(byte[] paramArrayOfbyte) {
        return toHexString(paramArrayOfbyte, 0, paramArrayOfbyte.length);
    }

    public static String toHexString(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
        byte[] arrayOfByte = encode(paramArrayOfbyte, paramInt1, paramInt2);
        return Strings.fromByteArray(arrayOfByte);
    }

    public static byte[] encode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            encoder.encode(paramArrayOfbyte, paramInt1, paramInt2, byteArrayOutputStream);
        } catch (Exception exception) {
            throw new EncoderException("exception encoding Hex string: " + exception.getMessage(), exception);
        }
        return byteArrayOutputStream.toByteArray();
    }

}
