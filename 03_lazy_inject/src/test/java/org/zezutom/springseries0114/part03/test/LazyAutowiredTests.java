package org.zezutom.springseries0114.part03.test;

import org.grep4j.core.model.Profile;
import org.grep4j.core.model.ProfileBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zezutom.springseries0114.part03.lazy.Car;

import static org.grep4j.core.Grep4j.grep;
import static org.grep4j.core.Grep4j.regularExpression;
import static org.grep4j.core.fluent.Dictionary.executing;
import static org.grep4j.core.fluent.Dictionary.on;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:spring-config.xml")
public class LazyAutowiredTests {

    @Qualifier(value = "lazyCar")
    @Autowired
    private Car car;

    private Profile profile = ProfileBuilder
            .newBuilder()
            .name("Spring logs")
            .filePath("target/spring.log").onLocalhost().build();

    @Test
    public void lazilyInjectedBeanIsNotPreloaded() {
        assertThat(executing(grep(regularExpression("Creating instance of bean(.*)lazySeat"), on(profile))).totalLines(), is(0));
    }

    @Test
    public void lazilyInjectedBeanIsAvailableWhenAskedFor() {
         assertNotNull(car.getDriver());
         assertNotNull(car.getPassenger());
    }

    @Test
    public void lazyAutowiredRespectsThePrototypeScope() {
         assertFalse(car.getDriver().equals(car.getPassenger()));
    }


}
