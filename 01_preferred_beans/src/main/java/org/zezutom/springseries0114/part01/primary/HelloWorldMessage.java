package org.zezutom.springseries0114.part01.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class HelloWorldMessage implements IMessage {

    @Override
    public String getMessage() {
        return "Hello world!";
    }
}
