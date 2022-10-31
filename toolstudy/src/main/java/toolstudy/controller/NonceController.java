package toolstudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolstudy.anno.AntiReply;
import toolstudy.anno.Encrypt;
import toolstudy.common.R;
import toolstudy.support.SimpleResponse;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Map;

@RestController
@Slf4j
public class NonceController {

    @GetMapping("/1/tst1")
    @AntiReply
    public SimpleResponse tst1() {
        SimpleResponse response = new SimpleResponse();
        response.setContent("哈哈");
        return response;
    }

    @PostMapping("/2/tst2")
    @Encrypt
    public R<Map<String, Object>> tst2() {
        Map<String, Object> map = Map.of("name", "波波", "age", 2);
        return R.ok(map);
    }

    @PostMapping("/3/tst3")
    public R<Map<String, Object>> tst3(@RequestBody @Encrypt Map<String, Object> map) {
        log.info("{}", map);
        return R.ok(map);
    }

    @PostMapping("/4/tst4")
    public R<Map<String, Object>> tst4(HttpServletRequest request, @RequestBody Map<String, Object> map) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String cusName = request.getHeader("cusName");
        System.out.println(cusName);
        log.info("{}", map);
        return R.ok(map);
    }

}
