package org.zezutom.springseries0114.part02.qualifier;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Stockholm implements ICapital {

    @Override
    public String name() {
        return "Stockholm";
    }
}
