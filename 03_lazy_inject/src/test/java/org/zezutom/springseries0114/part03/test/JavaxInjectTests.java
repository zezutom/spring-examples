package org.zezutom.springseries0114.part03.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zezutom.springseries0114.part03.inject.Car;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:spring-config.xml")
public class JavaxInjectTests {

    @Autowired
    private Car car;

    @Test
    public void injectionPointWorksAsExpected() {
        assertNotNull(car.getDriver());
        assertNotNull(car.getPassenger());
    }

    @Test
    public void injectionRespectsThePrototypeScope() {
         assertFalse(car.getDriver().equals(car.getPassenger()));
    }
}
