package Chapter01.controller.req;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class GetSmsCodeReq {
    @NotBlank(message = "手机号不能为空")
    private String mobile;
}
