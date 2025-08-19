package com.example.gestionemagazzino.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

public class AspectControllerDeposito {

    @Pointcut(value = "execution(* com.example.gestionemagazzino.Controller.DepositoController.*(..))")
    public void metodi() {}

    @Before( value = "metodi()")
    public void log(JoinPoint joinPoint) {
        System.out.println("log to depositoController method " + joinPoint.getSignature().getName());
        System.out.println( "lista: "+ Arrays.toString(joinPoint.getArgs()));
    }

    @After( value = "metodi()")
    public void exit(JoinPoint joinPoint) {
        System.out.println("exit to  depositoController method " + joinPoint.getSignature().getName());
        System.out.println( "lista: "+ Arrays.toString(joinPoint.getArgs()));
    }
}
