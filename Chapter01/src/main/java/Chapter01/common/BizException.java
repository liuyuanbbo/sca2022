package Chapter01.common;

import javax.servlet.ServletException;

public class BizException extends ServletException {
    private Integer code;
    private String message;

    public BizException() {
    }

    public BizException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BizException(int code, Throwable rootCause) {
        super(rootCause);
        this.code = code;
        this.message = rootCause.getMessage();
    }

    public BizException(int code, String message, Throwable rootCause) {
        super(rootCause);
        this.code = code;
        this.message = message;
    }
}
