package io.github.lostbalckknight.api;

/**
 * @author chensixiang chensixiang1234@gmail.com
 */
public enum MyCode {
    A(0, "good"),
    B(0, "goos"),
    C(0, "gooh"),
    D(0, "goop");

    private final Integer code;
    @FieldMapping("name")
    private final String name;

    MyCode(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
