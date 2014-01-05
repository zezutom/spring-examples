package org.zezutom.springexamples.qualifier;

import org.springframework.stereotype.Service;

@Service("banana")
public class Banana implements IFruit {

    @Override
    public String whoAmI() {
        return "banana";
    }
}
