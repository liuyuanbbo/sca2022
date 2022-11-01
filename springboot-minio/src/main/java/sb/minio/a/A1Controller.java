package sb.minio.a;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/a01")
@Slf4j
public class A1Controller {

    @PostMapping("/01")
    public String a1_01() {
        return "a1_01 () ...";
    }

    @PostMapping("/02")
    public String a1_02(@RequestBody Form2 form2) {
        String jsonStr = ReflectionToStringBuilder.toString(form2, ToStringStyle.MULTI_LINE_STYLE);
        log.info("{}", jsonStr);
        return jsonStr;
    }

    @Getter
    @Setter
    @ToString
    static class Form2 {
        private Integer id;
        private String name;
        private String pwd;
        private List<String> hobbies;
    }

}
