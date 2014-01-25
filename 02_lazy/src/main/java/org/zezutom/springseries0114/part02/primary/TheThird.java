package org.zezutom.springseries0114.part02.primary;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class TheThird implements IOrdinal {

    @Override
    public String count() {
        return "third";
    }
}
