package cc.mrbird.common.exception;

/**
 * BusinessException
 *
 * @author: fengwang
 * @date: 2019-03-25 10:18
 * @version: 1.0
 * @since: JDK 1.8
 */
public class BusinessException extends RuntimeException {
    /**
     * 异常信息
     */
    private String errorMsg;

    /**
     * 错误码
     */
    private String errorCode;

    public BusinessException() {
        super();
    }

    public BusinessException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String errorMsg, Throwable cause) {
        super(errorMsg, cause);
        this.errorMsg = errorMsg;
    }

    public BusinessException(String errorMsg, String errorCode) {
        super(errorMsg);
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    public BusinessException(String errorMsg, String errorCode, Throwable cause) {
        super(errorMsg, cause);
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    /**
     * @return the errorMsg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * @param errorMsg the errorMsg to set
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /**
     * @return the errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
