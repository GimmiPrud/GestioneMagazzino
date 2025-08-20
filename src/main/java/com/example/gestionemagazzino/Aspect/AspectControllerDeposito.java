package com.example.gestionemagazzino.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
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

    @Around(value = "metodi()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long tempoDiEntrata = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();

        long tempoDiFine = System.currentTimeMillis();
        System.out.println( "tempo di esecuzione del metodo " + joinPoint.getSignature().getName() + " : " + (tempoDiFine - tempoDiEntrata) + " ms");
        return proceed;
    }

    @AfterThrowing(value = "metodi()")
    public void exception(JoinPoint joinPoint) {
        System.out.print("Qualcosa è andato storto, è stata lanciata una eccezione per il seguente metodo "+joinPoint.getSignature().getName());
    }
}
