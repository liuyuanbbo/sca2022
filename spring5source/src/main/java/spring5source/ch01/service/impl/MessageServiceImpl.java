package spring5source.ch01.service.impl;

import org.springframework.stereotype.Service;
import spring5source.ch01.service.IMessageService;

@Service
public class MessageServiceImpl implements IMessageService {
    @Override
    public String echo(String msg) {
        return "【 ECHO 】" + msg;
    }
}
