package org.zezutom.springseries0114.part02.qualifier;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class London implements ICapital {
    @Override
    public String name() {
        return "London";
    }
}
