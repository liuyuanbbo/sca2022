package spring5source.a;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenericTest {

    @FunctionalInterface
    interface Ia {
        void print();
    }

    static class IaImpl implements Ia {

        @Override
        public void print() {
            log.info("ia ia ia print");
        }
    }

    static class IaaImpl implements Ia {
        @Override
        public void print() {
            log.info("iaa iaa iaa print");
        }
    }

    public static <T extends Ia> void printClz(T t) {
        log.info("clz: {} ", t.getClass());
        t.print();
    }

    public static void main(String[] args) {
        printClz(new IaImpl());
        printClz(new IaaImpl());
    }
}
