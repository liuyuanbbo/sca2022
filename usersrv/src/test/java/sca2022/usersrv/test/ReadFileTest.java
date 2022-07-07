package sca2022.usersrv.test;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.charset.Charset;
import java.util.*;

@Slf4j
public class ReadFileTest {
    @Test
    public void tst1() {
        String path = "E:\\worksp\\jz-worksp\\LocalEmsServer\\src\\main\\java\\com\\jz";
        File file = new File(path);
        appendFile(file);
    }

    @Test
    public void tst2() {
        Integer i1 = 42;
        long l1 = 42L;
        double d1 = 42.0;
        log.info("{}", l1 == i1);
        log.info("{}", d1 == i1);
        log.info("{}", d1 == l1);
    }

    @Test
    public void tst3() {
        Map<Integer, String> map = new HashMap<>();

        List<Integer> ints = new ArrayList<>();
        Set<Integer> sets = new HashSet<>();


        for (int i = 0; i < 30; i++) {
            int r = RandomUtil.randomInt(1, 300);
            ints.add(r);
            sets.add(r);
            map.put(r, r + "");
        }

        System.out.println(ints);
        System.out.println(sets);
        System.out.println(map.keySet());
        System.out.println(map.values());
    }

    private void appendFile(File file) {
        File f = new File("D:\\worksp\\tmp\\code.txt");
        if (file.isDirectory()) {
            for (File listFile : Objects.requireNonNull(file.listFiles())) {
                appendFile(listFile);
            }
        } else {
            String fileName = file.getName();
            if (fileName.endsWith(".java")) {
                List<String> strs = FileUtil.readLines(file, Charset.defaultCharset());
                FileUtil.writeLines(strs, f, Charset.defaultCharset(), true);
                strs.clear();
            }
        }
    }
}
