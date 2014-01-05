package org.zezutom.springexamples.primary;

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
