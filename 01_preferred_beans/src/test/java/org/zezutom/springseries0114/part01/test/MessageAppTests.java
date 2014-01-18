package org.zezutom.springseries0114.part01.test;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zezutom.springseries0114.part01.primary.IMessage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class MessageAppTests {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private IMessage message;

    @Test
    public void applicationContextShouldExist() {
        Assert.assertNotNull(context);
    }

    @Test
    public void helloWorldShouldBeTheDefaultMessage() {
        Assert.assertEquals(String.format("Hello world!"), message.getMessage());
    }

    @Test
    public void primaryBeanShouldBePickedByTheGetBeanCall() {
        Assert.assertEquals("Hello world!", context.getBean(IMessage.class).getMessage());
    }

}
