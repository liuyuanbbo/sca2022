package spring5source.ch03.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@Slf4j
@RequestMapping("/c3")
public class C3Controller {

    @RequestMapping("/m1")
    public void m1(@RequestBody PageForm form, @PageableDefault(page = 2, size = 200) Pageable pageable) {
        if (form != null && pageable != null) {
            System.out.println(form);
            System.out.println(pageable);
        }
    }

    @Getter
    @Setter
    @ToString
    static class PageForm implements Serializable {
        private String name;
        private Integer age;
    }
}
