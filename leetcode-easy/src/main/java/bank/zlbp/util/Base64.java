package bank.zlbp.util;

/**
 * @author jiaoxian
 * @name bank.zlbp.util
 * @date 2023/12/13 17:05
 * @description TODO
 */

import java.math.BigInteger;
public class Base64 extends BaseNCodec {

    private static final int BITS_PER_ENCODED_BYTE = 6;

    private static final int BYTES_PER_UNENCODED_BLOCK = 3;

    private static final int BYTES_PER_ENCODED_BLOCK = 4;

    static final byte[] CHUNK_SEPARATOR = new byte[] { 13, 10 };

    private static final byte[] STANDARD_ENCODE_TABLE = new byte[] {
            65, 66, 67, 68, 69, 70, 71, 72, 73, 74,
            75, 76, 77, 78, 79, 80, 81, 82, 83, 84,
            85, 86, 87, 88, 89, 90, 97, 98, 99, 100,
            101, 102, 103, 104, 105, 106, 107, 108, 109, 110,
            111, 112, 113, 114, 115, 116, 117, 118, 119, 120,
            121, 122, 48, 49, 50, 51, 52, 53, 54, 55,
            56, 57, 43, 47 };

    private static final byte[] URL_SAFE_ENCODE_TABLE = new byte[] {
            65, 66, 67, 68, 69, 70, 71, 72, 73, 74,
            75, 76, 77, 78, 79, 80, 81, 82, 83, 84,
            85, 86, 87, 88, 89, 90, 97, 98, 99, 100,
            101, 102, 103, 104, 105, 106, 107, 108, 109, 110,
            111, 112, 113, 114, 115, 116, 117, 118, 119, 120,
            121, 122, 48, 49, 50, 51, 52, 53, 54, 55,
            56, 57, 45, 95 };

    private static final byte[] DECODE_TABLE = new byte[] {
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, 62, -1, 62, -1, 63, 52, 53,
            54, 55, 56, 57, 58, 59, 60, 61, -1, -1,
            -1, -1, -1, -1, -1, 0, 1, 2, 3, 4,
            5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
            15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
            25, -1, -1, -1, -1, 63, -1, 26, 27, 28,
            29, 30, 31, 32, 33, 34, 35, 36, 37, 38,
            39, 40, 41, 42, 43, 44, 45, 46, 47, 48,
            49, 50, 51 };

    private static final int MASK_6BITS = 63;

    private final byte[] encodeTable;

    private final byte[] decodeTable = DECODE_TABLE;

    private final byte[] lineSeparator;

    private final int decodeSize;

    private final int encodeSize;


    public Base64(int lineLength, byte[] lineSeparator, boolean urlSafe) {
        super(3, 4, lineLength, (lineSeparator == null) ? 0 : lineSeparator.length);
        if (lineSeparator != null) {
            if (containsAlphabetOrPad(lineSeparator)) {
                String sep = StringUtils.newStringUtf8(lineSeparator);
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + sep + "]");
            }
            if (lineLength > 0) {
                this.encodeSize = 4 + lineSeparator.length;
                this.lineSeparator = new byte[lineSeparator.length];
                System.arraycopy(lineSeparator, 0, this.lineSeparator, 0, lineSeparator.length);
            } else {
                this.encodeSize = 4;
                this.lineSeparator = null;
            }
        } else {
            this.encodeSize = 4;
            this.lineSeparator = null;
        }
        this.decodeSize = this.encodeSize - 1;
        this.encodeTable = urlSafe ? URL_SAFE_ENCODE_TABLE : STANDARD_ENCODE_TABLE;
    }

    protected boolean isInAlphabet(byte octet) {
        return (octet >= 0 && octet < this.decodeTable.length && this.decodeTable[octet] != -1);
    }

    public boolean isInAlphabet(byte[] arrayOctet, boolean allowWSPad) {
        for (byte octet : arrayOctet) {
            if (!isInAlphabet(octet) && (!allowWSPad || (octet != this.pad &&
                    !isWhiteSpace(octet)))) {
                return false;
            }
        }
        return true;
    }

    public boolean isInAlphabet(String basen) {
        return isInAlphabet(StringUtils.getBytesUtf8(basen), true);
    }

    protected boolean containsAlphabetOrPad(byte[] arrayOctet) {
        if (arrayOctet == null) {
            return false;
        }
        for (byte element : arrayOctet) {
            if (this.pad == element || isInAlphabet(element)) {
                return true;
            }
        }
        return false;
    }

}
