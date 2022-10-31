package spring5source.a;

import org.springframework.util.Base64Utils;

import java.util.HashMap;

public class Base64Test {
    public static void main(String[] args) {
        byte[] encode = Base64Utils.encode("efunds.com.cn".getBytes());
        System.out.println(new String(encode));

        System.out.println("==============");
        var map = new HashMap<String, String>();
        map.put("aa", "AAA");
        map.computeIfAbsent("bb", k -> map.get("aa"));
        map.remove("aa");
        System.out.println(map);
    }
}
