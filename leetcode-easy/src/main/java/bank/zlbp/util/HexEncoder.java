package bank.zlbp.util;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author jiaoxian
 * @name bank.zlbp.util
 * @date 2023/12/13 17:27
 * @description TODO
 */
public class HexEncoder implements Encoder {

    protected final byte[] encodingTable = new byte[] {
            48, 49, 50, 51, 52, 53, 54, 55, 56, 57,
            97, 98, 99, 100, 101, 102 };

    @Override
    public int encode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, OutputStream paramOutputStream) throws IOException {
        for (int i = paramInt1; i < paramInt1 + paramInt2; i++) {
            int j = paramArrayOfbyte[i] & 0xFF;
            paramOutputStream.write(this.encodingTable[j >>> 4]);
            paramOutputStream.write(this.encodingTable[j & 0xF]);
        }
        return paramInt2 * 2;
    }
}
