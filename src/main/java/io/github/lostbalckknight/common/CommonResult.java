package io.github.lostbalckknight.common;

import java.util.Objects;

/**
 * 通用响应结果
 *
 * @author chensixiang chensixiang1234@gmail.com
 */
@SuppressWarnings("unused")
public class CommonResult<T> {
    /**
     * HTTP响应代码
     */
    private Integer code;
    /**
     * 消息
     */
    private String message;
    /**
     * 数据
     */
    private T data;

    public CommonResult() {
    }

    public CommonResult(Integer code) {
        this(code, null);
    }

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonResult(Code code) {
        this(code.getCode());
    }

    public CommonResult(Code code, String message) {
        this(code.getCode(), message);
    }

    public CommonResult(Code code, String message, T data) {
        this(code.getCode(), message, data);
    }

    // 200x

    /**
     * 200
     *
     * @param <T> 结果类型
     * @return 响应结果
     */
    public static <T> CommonResult<T> ok() {
        return new CommonResult<>(Code.OK);
    }

    /**
     * 200
     *
     * @param message 消息
     * @param <T>     结果类型
     * @return 响应结果
     */
    public static <T> CommonResult<T> ok(String message) {
        return new CommonResult<>(Code.OK, message);
    }

    /**
     * 200
     *
     * @param message 消息
     * @param data    数据
     * @param <T>     结果类型
     * @return 响应结果
     */
    public static <T> CommonResult<T> ok(String message, T data) {
        return new CommonResult<>(Code.OK, message, data);
    }

    // 400x

    /**
     * 400
     *
     * @param <T> 结果类型
     * @return 响应结果
     */
    public static <T> CommonResult<T> badRequest() {
        return new CommonResult<>(Code.BadRequest);
    }

    /**
     * 400
     *
     * @param message 消息
     * @param <T>     结果类型
     * @return 响应结果
     */
    public static <T> CommonResult<T> badRequest(String message) {
        return new CommonResult<>(Code.BadRequest, message);
    }

    /**
     * 400
     *
     * @param message 消息
     * @param data    数据
     * @param <T>     结果类型
     * @return 响应结果
     */
    public static <T> CommonResult<T> badRequest(String message, T data) {
        return new CommonResult<>(Code.BadRequest, message, data);
    }

    /**
     * 401
     *
     * @param <T> 结果类型
     * @return 响应结果
     */
    public static <T> CommonResult<T> unauthorized() {
        return new CommonResult<>(Code.Unauthorized);
    }

    /**
     * 401
     *
     * @param message 消息
     * @param <T>     结果类型
     * @return 响应结果
     */
    public static <T> CommonResult<T> unauthorized(String message) {
        return new CommonResult<>(Code.Unauthorized, message);
    }

    /**
     * 401
     *
     * @param message 消息
     * @param data    数据
     * @param <T>     结果类型
     * @return 响应结果
     */
    public static <T> CommonResult<T> unauthorized(String message, T data) {
        return new CommonResult<>(Code.Unauthorized, message, data);
    }

    /**
     * 403
     *
     * @param <T> 结果类型
     * @return 响应结果
     */
    public static <T> CommonResult<T> forbidden() {
        return new CommonResult<>(Code.Forbidden);
    }

    /**
     * 403
     *
     * @param message 消息
     * @param <T>     结果类型
     * @return 响应结果
     */
    public static <T> CommonResult<T> forbidden(String message) {
        return new CommonResult<>(Code.Forbidden, message);
    }

    /**
     * 403
     *
     * @param message 消息
     * @param data    数据
     * @param <T>     结果类型
     * @return 响应结果
     */
    public static <T> CommonResult<T> forbidden(String message, T data) {
        return new CommonResult<>(Code.Forbidden, message, data);
    }

    /**
     * 404
     *
     * @param <T> 结果类型
     * @return 响应结果
     */
    public static <T> CommonResult<T> notFound() {
        return new CommonResult<>(Code.NotFound);
    }

    /**
     * 404
     *
     * @param message 消息
     * @param <T>     结果类型
     * @return 响应结果
     */
    public static <T> CommonResult<T> notFound(String message) {
        return new CommonResult<>(Code.NotFound, message);
    }

    /**
     * 404
     *
     * @param message 消息
     * @param data    数据
     * @param <T>     结果类型
     * @return 响应结果
     */
    public static <T> CommonResult<T> notFound(String message, T data) {
        return new CommonResult<>(Code.NotFound, message, data);
    }

    // 500x

    /**
     * 500
     *
     * @param <T> 结果类型
     * @return 响应结果
     */
    public static <T> CommonResult<T> internalServerError() {
        return new CommonResult<>(Code.InternalServerError);
    }

    /**
     * 500
     *
     * @param message 消息
     * @param <T>     结果类型
     * @return 响应结果
     */
    public static <T> CommonResult<T> internalServerError(String message) {
        return new CommonResult<>(Code.InternalServerError, message);
    }

    /**
     * 500
     *
     * @param message 消息
     * @param data    数据
     * @param <T>     结果类型
     * @return 响应结果
     */
    public static <T> CommonResult<T> internalServerError(String message, T data) {
        return new CommonResult<>(Code.InternalServerError, message, data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonResult<?> that = (CommonResult<?>) o;
        return Objects.equals(code, that.code) && Objects.equals(message, that.message) && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message, data);
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
