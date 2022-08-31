package test.a0;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import toolstudy.a0.BeanCopierUtil;

@Slf4j
public class BeanCopierUtilTest {
    @Test
    public void a0_1() {
        A01 a01 = new A01();
        a01.setName("a01");
        log.info("{}", a01);
        A02 a02 = BeanCopierUtil.copy(a01, A02::new);
        log.info("{}", a02);
    }

    static class A0 {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "A0{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    static class A01 extends A0 {
        private Integer age;

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "A01{" +
                    "age=" + age +
                    ", name='" + this.getName() + '\'' +
                    '}';
        }
    }

    static class A02 extends A0 {
        private Double dd;

        public Double getDd() {
            return dd;
        }

        public void setDd(Double dd) {
            this.dd = dd;
        }

        @Override
        public String toString() {
            return "A02{" +
                    "dd=" + dd +
                    ", name='" + this.getName() + '\'' +
                    '}';
        }
    }
}
