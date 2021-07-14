package io.github.lostbalckknight.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chensixiang chensixiang1234@gmail.com
 */
class CommonResultTest {

    @Test
    public void test1() {
        CommonResult<Object> result = CommonResult.notFound("为找到","页面丢了");
        System.out.println(result);
    }
}