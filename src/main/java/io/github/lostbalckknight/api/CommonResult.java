package io.github.lostbalckknight.api;

/**
 * 通用响应结果
 *
 * @param <T> 数据类型
 * @author chensixiang chensixiang1234@gmail.com
 */
@SuppressWarnings({"unused"})
public class CommonResult<T> extends AbstractResult<Integer, String, T> {
    /**
     * 通用响应结果构造者
     *
     * @return {@link CommonResult.CommonResultBuilder}
     */
    public CommonResultBuilder<T> builder() {
        return new CommonResultBuilder<>(new CommonResult<>());
    }

    /**
     * 通用响应结果构建器
     *
     * @param <T> 数据类型
     * @author chensixiang chensixiang1234@gmail.com
     */
    public static class CommonResultBuilder<T> extends AbstractResultBuilder<CommonResult<T>, Integer, String, T> {
        public CommonResultBuilder(CommonResult<T> result) {
            super(result);
        }
    }

    public CommonResult() {
    }

    public CommonResult(Enum<?> status) {
        super(status);
    }

    public CommonResult(Enum<?> status, T data) {
        super(status, data);
    }

    public CommonResult(Integer code) {
        super(code);
    }

    public CommonResult(Integer code, String message) {
        super(code, message);
    }

    public CommonResult(Integer code, T data) {
        super(code, data);
    }

    public CommonResult(Integer code, String message, T data) {
        super(code, message, data);
    }

    public Integer getCode() {
        return super.code;
    }

    public String getMessage() {
        return super.message;
    }

    public T getData() {
        return super.data;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "code=" + code +
                ", message=" + message +
                ", data=" + data +
                ", status=" + status +
                '}';
    }
}
