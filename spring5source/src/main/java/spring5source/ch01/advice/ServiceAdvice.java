package spring5source.ch01.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceAdvice.class);

    public void beforeHandler() {
        LOGGER.info(">>>>>> 前置处理逻辑11 >>>>>> ");
    }

    public void afterHandler() {
        LOGGER.info("====== 后置处理逻辑22 ====== ");
    }
}
