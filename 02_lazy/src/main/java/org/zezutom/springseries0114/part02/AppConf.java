package org.zezutom.springseries0114.part02;

import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackageClasses = BeanLogger.class)
public class AppConf {

    @Bean
    @Lazy
    public BeanA beanA() {
        return new BeanA();
    }

    @Bean
    @Lazy(value = false)
    public BeanB beanB() {
        return new BeanB();
    }

    @Bean
    public BeanC beanC() {
        return new BeanC();
    }

    @Bean
    @Scope(value = "prototype")
    public BeanD beanD() {
        return new BeanD();
    }

    @Bean
    @Lazy
    public Foo foo() {
        return new Foo();
    }

    @Bean
    public Bar bar() {
        return new Bar();
    }

}
