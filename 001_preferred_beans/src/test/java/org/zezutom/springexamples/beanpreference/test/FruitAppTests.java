package org.zezutom.springexamples.beanpreference.test;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zezutom.springexamples.qualifier.IFruit;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class FruitAppTests {

    @Qualifier("apple")
    @Autowired
    private IFruit fruit;

    @Resource(name = "banana")
    private IFruit fruit2;

    @Test
    public void anAppleShouldBeAutowired() {
        Assert.assertEquals("apple", fruit.whoAmI());
    }

    @Test
    public void aBananaShouldBeTheResource() {
        Assert.assertEquals("banana", fruit2.whoAmI());
    }

}
