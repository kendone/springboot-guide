package com.kendo.scanimportbean;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author kendone
 */
@Aspect
public class LogAspectJ {

    @Before("execution(* *.helloExecute(..))")
    public void logBeforeExecute() {
        System.out.println("方法执行前日志记录");
    }

    @After("execution(* *.helloExecute(..))")
    public void logAfterExecute() {
        System.out.println("方法执行后日志记录");
    }
}
