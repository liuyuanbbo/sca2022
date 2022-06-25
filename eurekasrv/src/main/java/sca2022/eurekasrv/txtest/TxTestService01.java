package sca2022.eurekasrv.txtest;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.support.GenericApplicationContext;
import sca2022.eurekasrv.config.TxConfig;
import sca2022.eurekasrv.service.TxService01;

import java.io.FileNotFoundException;

public class TxTestService01 {
    public static void main(String[] args) throws FileNotFoundException {
        GenericApplicationContext ctx = new GenericApplicationContext();
        DefaultListableBeanFactory defaultListableBeanFactory = ctx.getDefaultListableBeanFactory();
        AnnotationConfigUtils.registerAnnotationConfigProcessors(defaultListableBeanFactory);
        ConfigurationPropertiesBindingPostProcessor.register(defaultListableBeanFactory);

        ctx.registerBean(TxConfig.class);
        ctx.refresh();

        TxService01 txService01 = ctx.getBean(TxService01.class);
        txService01.transfer(1, 2, 500);
    }
}