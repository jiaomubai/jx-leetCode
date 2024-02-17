package bank.zlbp.util;

/**
 * @author jiaoxian
 * @name bank.zlbp.util
 * @date 2023/12/13 17:22
 * @description TODO
 */
public interface DsaSigner {
    byte[] sign(byte[] paramArrayOfbyte);
}
