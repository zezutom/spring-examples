package org.zezutom.springseries0114.part03.lazy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "lazySeat")
@Scope(value = "prototype")
public class Seat {
}
