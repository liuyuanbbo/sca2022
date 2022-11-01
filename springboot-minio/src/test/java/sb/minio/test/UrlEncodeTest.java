package sb.minio.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Slf4j
public class UrlEncodeTest {

    @Test
    public void tst1() throws UnsupportedEncodingException {
        String s = URLEncoder.encode("工商银行", "utf-8");
        log.info("{}", s);
    }

}
