package org.zezutom.springseries0114.part02.test;

import org.grep4j.core.model.Profile;
import org.grep4j.core.model.ProfileBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zezutom.springseries0114.part02.primary.IOrdinal;

import static org.grep4j.core.Grep4j.grep;
import static org.grep4j.core.Grep4j.regularExpression;
import static org.grep4j.core.fluent.Dictionary.executing;
import static org.grep4j.core.fluent.Dictionary.on;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class LazyVsPrimaryTests {

    @Autowired
    private IOrdinal ordinal;

    private Profile profile = ProfileBuilder
            .newBuilder()
            .name("Spring logs")
            .filePath("target/spring.log").onLocalhost().build();

    @Test
    public void theFirstIsUsedByDefault() {
        assertEquals("first", ordinal.count());
    }

    @Test
    public void theSecondIsPreloadedAlthoughItIsLazy() {
        assertThat(executing(grep(regularExpression("Creating instance of bean(.*)theSecond"), on(profile))).totalLines(), is(1));
    }

    @Test
    public void theThirdIsPreloadedAlthoughItIsPrototype() {
        assertThat(executing(grep(regularExpression("Creating instance of bean(.*)theThird"), on(profile))).totalLines(), is(1));
    }
}
