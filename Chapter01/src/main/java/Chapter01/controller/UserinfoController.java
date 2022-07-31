package Chapter01.controller;

import Chapter01.common.R;
import Chapter01.controller.req.GetSmsCodeReq;
import Chapter01.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/userinfo")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "用户信息模块")
public class UserinfoController {

    private final UserService userService;

    @Operation(summary = "获取短信验证码")
    @PostMapping("/get-sms-code")
    public R<Map<String, String>> getSmsCode(@RequestBody GetSmsCodeReq req) {
        String mobile = req.getMobile();
        String smsCode = userService.getSmsCode(mobile);
        return R.ok(Map.of("code", smsCode));
    }

}
