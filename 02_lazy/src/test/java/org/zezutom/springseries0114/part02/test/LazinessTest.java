package org.zezutom.springseries0114.part02.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zezutom.springseries0114.part02.AppConf;
import org.zezutom.springseries0114.part02.BeanLogger;

import java.util.Collection;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConf.class)
public class LazinessTest {

    @Autowired
    private ApplicationContext context;

    @Autowired
    BeanLogger beanLogger;

    private Collection<String> beans;

    @Before
    public void setUp() {
        this.beans = beanLogger.getBeans();
    }

    @After
    public void cleanUp() {
        beanLogger.reload();
    }

    @Test
    public void initialLoadRespectsLaziness() {
        // beanA is lazy
        assertFalse(beans.contains("beanA"));

        // beanB was explicitly marked as non-lazy
        assertTrue(beans.contains("beanB"));

        // beanC is a singleton
        assertTrue(beans.contains("beanC"));

        // beanD is a prototype
        assertFalse(beans.contains("beanD"));
    }

    @Test
    public void aLazyBeanIsInitializedOnRequest() {
        assertNotNull(context.getBean("beanA"));
        assertTrue(beans.contains("beanA"));
        assertTrue(beans.contains("beanD"));
    }

}
