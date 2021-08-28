package com.zty.ztyshop.handler;


import com.zty.ztyshop.common.BaseResponseVO;
import com.zty.ztyshop.common.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/**
 * 全局异常处理器
 *
 * @author 李佳 zion 18102466330@163.com
 * @version 1.0
 * @date 2019/4/17 13:38
 */
@Slf4j
@RestControllerAdvice
public class BaseExceptionHandler {

    /**
     * 业务异常拦截
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public BaseResponseVO serviceExceptionHandler(HttpServletRequest request, BaseException e) {
        return BaseResponseVO.serviceException(e);
    }


    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public BaseResponseVO handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder sb = new StringBuilder("参数校验失败:");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getField()).append("：").append(fieldError.getDefaultMessage()).append(", ");
        }
        String msg = sb.toString();
        return BaseResponseVO.fail(4001, msg);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public BaseResponseVO handleConstraintViolationException(ConstraintViolationException ex) {
        return BaseResponseVO.fail(4001, ex.getMessage());
    }

    /**
     * Exceptiont统一处理
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResponseVO handle(Exception e) {
        return BaseResponseVO.serviceException(e);
    }
}

