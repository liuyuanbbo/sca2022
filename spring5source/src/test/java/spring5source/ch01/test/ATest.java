package spring5source.ch01.test;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ATest {
    @Test
    public void t1() {
        val list = List.of("AA", "BB", "CC", "DD", "AA", "BB", "CC", "DD");
        String s = list.stream().filter("CC"::equals).findFirst().orElse(null);
        System.out.println(s);

    }
}
