package sb.minio.a;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a01")
public class A1Controller {

    @PostMapping("/01")
    public String a1_01() {
        return "a1_01 () ...";
    }

}
