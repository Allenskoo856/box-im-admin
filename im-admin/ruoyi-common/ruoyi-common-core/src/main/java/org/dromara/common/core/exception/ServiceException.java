package org.dromara.common.core.exception;

import java.io.Serial;

/**
 * 业务异常
 *
 * @author ruoyi
 */
public final class ServiceException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误提示
     */
    private String message;

    /**
     * 错误明细，内部调试错误
     */
    private String detailMessage;

    public ServiceException(String message) {
        this.message = message;
    }

    public ServiceException(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public ServiceException setMessage(String message) {
        this.message = message;
        return this;
    }

    public ServiceException setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
        return this;
    }

    public ServiceException() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ServiceException that = (ServiceException) o;
        return java.util.Objects.equals(code, that.code) &&
               java.util.Objects.equals(message, that.message) &&
               java.util.Objects.equals(detailMessage, that.detailMessage);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), code, message, detailMessage);
    }
}
