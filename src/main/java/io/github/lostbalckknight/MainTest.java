package io.github.lostbalckknight;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.lostbalckknight.api.CommonResult;
import io.github.lostbalckknight.api.HttpStatusCode;
import io.github.lostbalckknight.api.MyCode;
import io.github.lostbalckknight.api.MyResult;
import org.junit.jupiter.api.Test;

/**
 * @author chensixiang chensixiang1234@gmail.com
 */
public class MainTest {

    public static void main(String[] args) throws Exception {
    }


    @Test
    public void test() {
        CommonResult<String> result = new CommonResult<>(HttpStatusCode.BAD_GATEWAY, "你好毒");
    }

    @Test
    public void test2() {
        CommonResult<String> result = new CommonResult<>(HttpStatusCode.OK);
        System.out.println(result);
    }

    @Test
    public void test3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        MyResult result = new MyResult(MyCode.B, "啊啊啊");
        System.out.println(mapper.writeValueAsString(result));
    }

    @Test
    public void test4() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        CommonResult<String> build = new CommonResult<String>().builder().code(100).message("aaaaa").data("oooo").build();
        System.out.println(mapper.writeValueAsString(build));
        String s = mapper.writeValueAsString(new CommonResult<>(HttpStatusCode.OK, "世界"));
        System.out.println(s);
    }
}
