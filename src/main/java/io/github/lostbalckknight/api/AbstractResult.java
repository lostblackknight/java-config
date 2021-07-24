package io.github.lostbalckknight.api;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 抽象的响应结果，
 * <p>如果想要使用Json序列化{@link CommonResult#code}、{@link CommonResult#message}、{@link CommonResult#data}、{@link CommonResult#status} 必须要在子类中添加getter方法，可以参考默认的实现类
 * <p>实现类: {@link CommonResult}
 *
 * @param <C> 响应状态码的类型
 * @param <M> 消息的类型
 * @param <D> 数据的类型
 * @author chensixiang chensixiang1234@gmail.com
 */
@SuppressWarnings("unused")
public abstract class AbstractResult<C, M extends CharSequence, D> {
    /**
     * 响应状态码
     */
    protected C code;
    /**
     * 消息
     */
    protected M message;
    /**
     * 数据
     */
    protected D data;
    /**
     * 状态，通常由（响应状态码 + 消息）组成
     */
    protected Enum<?> status;

    /**
     * 抽象的响应结果构建器
     *
     * @param <R> 响应结果的类型 {@link AbstractResult}
     * @param <C> 响应状态码的类型
     * @param <M> 消息的类型
     * @param <D> 数据的类型
     * @author chensixiang chensixiang1234@gmail.com
     */
    public abstract static class AbstractResultBuilder<R extends AbstractResult<C, M, D>, C, M extends CharSequence, D> {
        protected final R result;

        public AbstractResultBuilder(R result) {
            this.result = result;
        }

        public AbstractResultBuilder<R, C, M, D> code(C code) {
            result.code = code;
            return this;
        }

        public AbstractResultBuilder<R, C, M, D> message(M message) {
            result.message = message;
            return this;
        }

        public AbstractResultBuilder<R, C, M, D> data(D data) {
            result.data = data;
            return this;
        }

        public R build() {
            return result;
        }
    }

    private void fieldMapping(Enum<?> status) {
        for (Field field : status.getDeclaringClass().getDeclaredFields()) {
            FieldMapping fieldMapping = field.getDeclaredAnnotation(FieldMapping.class);
            if (fieldMapping != null) {
                fieldMappingInvoke(status, field.getName(), fieldMapping.value());
            } else {
                for (Field f : this.getClass().getSuperclass().getDeclaredFields()) {
                    if (f.getName().equals(field.getName())) {
                        fieldMappingInvoke(status, field.getName(), f.getName());
                    }
                }
            }
        }
    }

    private void fieldMappingInvoke(Enum<?> status, String newValue, String defaultValue) {
        if ("".equals(defaultValue) || "".equals(newValue)) {
            throw new IllegalArgumentException("defaultValue or newValue is \"\"");
        }
        try {
            Method method = status.getClass().getMethod("get"
                    + newValue.substring(0, 1).toUpperCase()
                    + newValue.substring(1));
            try {
                Object result = method.invoke(status);
                Field declaredField = null;
                try {
                    declaredField = this.getClass().getSuperclass().getDeclaredField(defaultValue);
                } catch (NoSuchFieldException e) {
                    try {
                        declaredField = this.getClass().getDeclaredField(defaultValue);
                    } catch (NoSuchFieldException ex) {
                        ex.printStackTrace();
                    }
                }
                Objects.requireNonNull(declaredField);
                declaredField.setAccessible(true);
                declaredField.set(this, result);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public AbstractResult() {
    }

    public AbstractResult(Enum<?> status) {
        fieldMapping(status);
        this.status = status;
    }

    public AbstractResult(Enum<?> status, D data) {
        fieldMapping(status);
        this.status = status;
        this.data = data;
    }

    public AbstractResult(C code) {
        this(code, null, null);
    }

    public AbstractResult(C code, M message) {
        this(code, message, null);
    }

    public AbstractResult(C code, D data) {
        this(code, null, data);
    }

    public AbstractResult(C code, M message, D data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public void setCode(C code) {
        this.code = code;
    }

    public void setMessage(M message) {
        this.message = message;
    }

    public void setData(D data) {
        this.data = data;
    }
}
