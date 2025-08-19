package com.example.gestionemagazzino.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AspectController {

    @Pointcut(value = "execution(* com.example.gestionemagazzino.Controller.BancoController.*(..))")
    public void metodi() {}

    @Before( value = "metodi()")
    public void log(JoinPoint joinPoint) {
        System.out.println("log to bancoController methods" + joinPoint.getSignature().getName());
        System.out.println( "lista: "+ Arrays.toString(joinPoint.getArgs()));
    }

    @After( value = "metodi()")
    public void exit(JoinPoint joinPoint) {
        System.out.println("exit to  bancoController methods" + joinPoint.getSignature().getName());
        System.out.println( "lista: "+ Arrays.toString(joinPoint.getArgs()));
    }
}
