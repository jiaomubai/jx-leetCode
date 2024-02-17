package bank.zlbp.util;

/**
 * @author jiaoxian
 * @name bank.zlbp.util
 * @date 2023/12/13 17:33
 * @description TODO
 */
public class EncoderException extends IllegalStateException {
    private Throwable cause;

    EncoderException(String paramString, Throwable paramThrowable) {
        super(paramString);
        this.cause = paramThrowable;
    }

    public Throwable getCause() {
        return this.cause;
    }
}
