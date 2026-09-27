package org.dromara.common.redis.handler;

import cn.hutool.http.HttpStatus;
import com.baomidou.lock.exception.LockFailureException;
import jakarta.servlet.http.HttpServletRequest;
import org.dromara.common.core.domain.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Redis异常处理器
 *
 * @author AprilWind
 */
@RestControllerAdvice
public class RedisExceptionHandler {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(RedisExceptionHandler.class);


    /**
     * 分布式锁Lock4j异常
     */
    @ExceptionHandler(LockFailureException.class)
    public R<Void> handleLockFailureException(LockFailureException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("获取锁失败了'{}',发生Lock4j异常.", requestURI, e);
        return R.fail(HttpStatus.HTTP_UNAVAILABLE, "业务处理中，请稍后再试...");
    }

}
