package org.zezutom.springseries0114.part02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.support.AopUtils;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

@Component
@Aspect
public class BeanLogger {

    private Collection<String> beans = new HashSet<String>();

    @AfterReturning("execution(* org.zezutom.springseries0114.part02.*.*(..))" )
    public void logConstructor(JoinPoint joinPoint) {
        beans.add(joinPoint.getSignature().getName());
    }

    public Collection<String> getBeans() {
        return Collections.unmodifiableCollection(beans);
    }

    public void reload() {
        beans.clear();
    }
}
