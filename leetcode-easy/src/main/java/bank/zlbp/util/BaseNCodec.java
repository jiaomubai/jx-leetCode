package bank.zlbp.util;

/**
 * @author jiaoxian
 * @name bank.zlbp.util
 * @date 2023/12/13 17:07
 * @description TODO
 */
public abstract class BaseNCodec {

    static final int EOF = -1;

    public static final int MIME_CHUNK_SIZE = 76;

    public static final int PEM_CHUNK_SIZE = 64;

    private static final int DEFAULT_BUFFER_RESIZE_FACTOR = 2;

    private static final int DEFAULT_BUFFER_SIZE = 8192;

    protected static final int MASK_8BITS = 255;

    protected static final byte PAD_DEFAULT = 61;

    protected final byte pad;

    private final int unencodedBlockSize;

    private final int encodedBlockSize;

    protected final int lineLength;

    private final int chunkSeparatorLength;
    protected BaseNCodec(int unencodedBlockSize, int encodedBlockSize, int lineLength, int chunkSeparatorLength) {
        this(unencodedBlockSize, encodedBlockSize, lineLength, chunkSeparatorLength, (byte)61);
    }

    protected BaseNCodec(int unencodedBlockSize, int encodedBlockSize, int lineLength, int chunkSeparatorLength, byte pad) {
        this.unencodedBlockSize = unencodedBlockSize;
        this.encodedBlockSize = encodedBlockSize;
        boolean useChunking = (lineLength > 0 && chunkSeparatorLength > 0);
        this.lineLength = useChunking ? (lineLength / encodedBlockSize * encodedBlockSize) : 0;
        this.chunkSeparatorLength = chunkSeparatorLength;
        this.pad = pad;
    }

    protected static boolean isWhiteSpace(byte byteToCheck) {
        switch (byteToCheck) {
            case 9:
            case 10:
            case 13:
            case 32:
                return true;
        }
        return false;
    }

}
