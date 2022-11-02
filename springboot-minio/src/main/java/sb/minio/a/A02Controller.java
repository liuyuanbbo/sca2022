package sb.minio.a;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a02")
@Slf4j
public class A02Controller {

    @PostMapping("/01")
    public String a2_01() {
        return "a02 01() ...............";
    }

}
