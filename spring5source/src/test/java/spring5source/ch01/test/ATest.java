package spring5source.ch01.test;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ATest {
    @Test
    public void t1() {
        val list = List.of("AA", "BB", "CC", "DD", "AA", "BB", "CC", "DD");
        String s = list.stream().filter("CC"::equals).findFirst().orElse(null);
        System.out.println(s);
    }

    @Test
    public void t2() {
        String[] strArr = new String[]{"2022", "11", "08"};
        //String[] newArr = Arrays.copyOf(strArr, 4);
        String[] newArr = new String[4];
        System.arraycopy(strArr, 0, newArr, 1, strArr.length);
        newArr[0] = "test";
        System.out.println(Arrays.toString(newArr));
    }
}
