package spring5source.a;

import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;
import spring5source.a.pojo.AUser;

@Slf4j
public class A1Main {
    public static void main(String[] args) {
        String str = new Yaml().dump(AUser.builder().name("波波").age(20).build());
        log.info("{}", str);
    }
}
