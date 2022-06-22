package sca2022.usersrv.test;

import cn.hutool.core.io.FileUtil;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Objects;

public class ReadFileTest {
    @Test
    public void tst1() {
        String path = "E:\\worksp\\jz-worksp\\LocalEmsServer\\src\\main\\java\\com\\jz";
        File file = new File(path);
        appendFile(file);
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
