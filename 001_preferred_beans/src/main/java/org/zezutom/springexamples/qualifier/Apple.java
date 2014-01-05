package org.zezutom.springexamples.qualifier;

import org.springframework.stereotype.Service;

@Service("apple")
public class Apple implements IFruit {

    @Override
    public String whoAmI() {
        return "apple";
    }
}
