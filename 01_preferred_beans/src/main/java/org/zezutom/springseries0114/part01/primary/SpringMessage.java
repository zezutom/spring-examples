package org.zezutom.springseries0114.part01.primary;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service("springMessage")
@Lazy
public class SpringMessage implements IMessage {

    @Override
    public String getMessage() {
        return "Spring is fun!";
    }
}
