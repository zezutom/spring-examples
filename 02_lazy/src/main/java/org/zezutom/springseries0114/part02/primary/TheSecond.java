package org.zezutom.springseries0114.part02.primary;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TheSecond implements IOrdinal {
    @Override
    public String count() {
        return "second";
    }
}
