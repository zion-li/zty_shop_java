package com.zty.ztyshop.common;


import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author 李佳 zion 18102466330@163.com
 * @version 1.0
 * @date 2019/4/17 13:39
 */
@Data
public class BaseResponseVO<M> {
    /**
     * 业务编号
     */
    private Integer code;
    /**
     * 异常信息
     */
    private String message;
    /**
     * 业务数据返回
     */
    private M data;

    private BaseResponseVO() {
    }

    public BaseResponseVO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 成功但是无参数
     *
     * @return
     */
    public static BaseResponseVO success() {
        BaseResponseVO response = new BaseResponseVO();
        response.setCode(200);
        response.setMessage("");
        return response;
    }

    /**
     * 成功有参数
     *
     * @param data
     * @param <M>
     * @return
     */
    public static <M> BaseResponseVO success(M data) {
        BaseResponseVO response = new BaseResponseVO();
        response.setCode(200);
        response.setMessage("");
        response.setData(data);
        return response;
    }

    /**
     * 失败
     *
     * @param code
     * @param message
     * @param <M>
     * @return
     */
    public static <M> BaseResponseVO fail(Integer code, String message) {
        BaseResponseVO response = new BaseResponseVO();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }

    public static BaseResponseVO ofMessage(int code, String message) {
        return new BaseResponseVO(code, message);
    }


    /**
     * 未登录异常
     *
     * @param <M>
     * @return
     */
    public static <M> BaseResponseVO noLogin() {
        BaseResponseVO response = new BaseResponseVO();
        response.setCode(401);
        response.setMessage("请登录");
        return response;
    }

    /**
     * 出现业务异常
     *
     * @param e
     * @param <M>
     * @return
     */
    public static <M> BaseResponseVO serviceException(BaseException e) {
        BaseResponseVO response = new BaseResponseVO();
        response.setCode(e.getCode());
        response.setMessage(e.getMessage());
        return response;
    }

    /**
     * 出现系统异常
     *
     * @param e
     * @param <M>
     * @return
     */
    public static <M> BaseResponseVO serviceException(Exception e) {
        BaseResponseVO response = new BaseResponseVO();
        response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setMessage(e.getMessage());
        return response;
    }

}