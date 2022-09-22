package spring5source.a;

import org.springframework.util.Base64Utils;

public class Base64Test {
    public static void main(String[] args) {
        byte[] encode = Base64Utils.encode("efunds.com.cn".getBytes());
        System.out.println(new String(encode));
    }
}
