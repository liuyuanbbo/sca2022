package spring5source.ch02.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class Ch02Service {

    public void test1() {
        CompletableFuture.supplyAsync(this::buildPersonList)
                .thenAccept(this::filter);
    }

    private List<Person> buildPersonList() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return List.of(
                new Person("aa", 10),
                new Person("bb", 11),
                new Person("cc", 12),
                new Person("dd", 13),
                new Person("ee", 14),
                new Person("ff", 15),
                new Person("gg", 16),
                new Person("hh", 17),
                new Person("ii", 18),
                new Person("jj", 19)
        );
    }

    private void filter(List<Person> persons) {
        for (Person p : persons) {
            Integer age = p.getAge();
            if (age > 15 && age < 20) {
                p.setMap(Map.of("age", age));
            }
        }
        log.info("{}", persons);
    }

    @Getter
    @Setter
    @ToString
    static class Person {
        private String name;
        private Integer age;
        private Map<String, Object> map;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }

}
