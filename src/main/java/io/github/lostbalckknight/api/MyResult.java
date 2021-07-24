package io.github.lostbalckknight.api;

/**
 * @author chensixiang chensixiang1234@gmail.com
 */
public class MyResult extends AbstractResult<Integer, String, Object> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyResult() {
    }

    public MyResult(Enum<?> status) {
        super(status);
    }

    public MyResult(Enum<?> status, Object data) {
        super(status, data);
    }

    public MyResult(Integer code) {
        super(code);
    }

    public MyResult(Integer code, String message) {
        super(code, message);
    }

    public MyResult(Integer code, Object data) {
        super(code, data);
    }

    public MyResult(Integer code, String message, Object data) {
        super(code, message, data);
    }

    @Override
    public String toString() {
        return "MyResult{" +
                "code=" + code +
                ", message=" + message +
                ", data=" + data +
                ", status=" + status +
                ", name='" + name + '\'' +
                '}';
    }
}
