package org.zezutom.springseries0114.part02.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TheFirst implements IOrdinal {

    @Override
    public String count() {
        return "first";
    }
}
