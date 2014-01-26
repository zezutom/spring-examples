package org.zezutom.springseries0114.part03.lazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component(value = "lazyCar")
public class Car {

    @Autowired
    @Lazy
    private Seat driver;

    @Autowired
    @Lazy
    private Seat passenger;

    public Seat getDriver() {
        return driver;
    }

    public Seat getPassenger() {
        return passenger;
    }
}
