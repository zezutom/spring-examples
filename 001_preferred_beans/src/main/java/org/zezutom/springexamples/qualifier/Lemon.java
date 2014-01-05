package org.zezutom.springexamples.qualifier;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service("lemon")
@Lazy
public class Lemon implements IFruit {

    @Override
    public String whoAmI() {
        return "lemon";
    }
}
