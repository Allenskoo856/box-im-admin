package org.dromara.common.sms.handler;

import cn.hutool.http.HttpStatus;
import jakarta.servlet.http.HttpServletRequest;
import org.dromara.common.core.domain.R;
import org.dromara.sms4j.comm.exception.SmsBlendException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * SMS异常处理器
 *
 * @author AprilWind
 */
@RestControllerAdvice
public class SmsExceptionHandler {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(SmsExceptionHandler.class);


    /**
     * sms异常
     */
    @ExceptionHandler(SmsBlendException.class)
    public R<Void> handleSmsBlendException(SmsBlendException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生sms短信异常.", requestURI, e);
        return R.fail(HttpStatus.HTTP_INTERNAL_ERROR, "短信发送失败，请稍后再试...");
    }

}
