package bank.zlbp.util;

/**
 * @author jiaoxian
 * @name bank.zlbp.util
 * @date 2023/12/13 17:26
 * @description TODO
 */
import java.io.IOException;
import java.io.OutputStream;

public interface Encoder {
    int encode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, OutputStream paramOutputStream) throws IOException;

//    int decode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, OutputStream paramOutputStream) throws IOException;
//
//    int decode(String paramString, OutputStream paramOutputStream) throws IOException;
}
