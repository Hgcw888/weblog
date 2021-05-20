package com.hgcw.weblog.common.exception;

import com.hgcw.weblog.common.lang.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author hgcw
 * @date 2021/5/12 21:19
 * 全局异常处理
 */
@Slf4j
//异步
@RestControllerAdvice
public class GlobalExcepitonHandler {
    // 捕捉shiro的异常
    @ResponseStatus(HttpStatus.UNAUTHORIZED)//获取http状态
    @ExceptionHandler(value = ShiroException.class)//用来统一处理方法抛出的异常
    public Result handler(ShiroException e){
        log.error("运行时异常：---------{}");
        return Result.fail(401,e.getMessage(),null);
    }
    //
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public Result handler(RuntimeException e){
        log.info("运行时异常：----------", e);
        return Result.fail(e.getMessage());
    }
}
