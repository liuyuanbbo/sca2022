package spring5source.ch03.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/c3")
public class C3Controller {

    private static final List<String> list = Collections.synchronizedList(new ArrayList<>());

    @RequestMapping("/m1")
    public void m1(@RequestBody PageForm form, @PageableDefault(page = 2, size = 200) Pageable pageable) {
        if (form != null && pageable != null) {
            System.out.println(form);
            System.out.println(pageable);
        }
    }

    @GetMapping("/m2")
    public String m2() {
        list.add(UUID.randomUUID().toString());
        return "压测c3 m2接口";
    }

    @GetMapping("/m3")
    public void m3() {
        log.info("{}", list.size());
    }

    @Getter
    @Setter
    @ToString
    static class PageForm implements Serializable {
        private String name;
        private Integer age;
    }
}
