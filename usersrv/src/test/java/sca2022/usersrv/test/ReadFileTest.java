package sca2022.usersrv.test;

import cn.hutool.core.io.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Objects;

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
