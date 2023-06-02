package com.example.aop.aspect;

import com.example.aop.model.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect {

    private final Logger logger = LoggerFactory.getLogger(UserAspect.class);

    @Before(value = "execution(* com.example.aop.controller.*.addUser(..))")
    public void beforeUserAdd(JoinPoint joinPoint){
        logger.info("Eklenen kullanıcı bilgileri: " + joinPoint.getArgs()[0]);
        logger.info(joinPoint.getKind());
        logger.info(joinPoint.getThis().toString());
    }

    @After(value = "execution(* com.example.aop.controller.*.addUser(..))")
    public void afterUserAdd(){
        logger.info("Kullanıcı eklendi");
    }

    @AfterReturning(value = "execution(* com.example.aop.controller.*.addUser(..))", returning = "user")
    public void afterReturningAddUser(User user){
        logger.info("Kullanıcı eklendi eklenen kullanıcı bilgileri: \n" +
                "User name: " + user.getName() + "\n" +
                "User mail: " + user.getEmail() + "\n" +
                "User number: " + user.getNumber() + "\n"
        );
    }

    @Pointcut(value = "execution(* com.example.aop.controller.*.*(..))")
    public void controllerPackagePointcut(){
        System.out.println("asdada");
    }

    // veya kullanarak birden fazla metod belirtebiliriz.
    @AfterThrowing(value = "execution(* com.example.aop.controller.*.addUser(..)) || execution(* com.example.aop.controller.*.updateUser(..))", throwing = "e")
    public void afterThrowing(Exception e){
        logger.error("Kullanıcı eklenirken veya güncellerken hata ile karşılaşıldı: " + e.getMessage());
    }

    // around özelliği diğer özellikleri devre dışı mı bırakıyor???
//    @Around(value = "execution(* com.example.aop.controller.*.addUser(..))")
//    public void aroundAddUser(){
//        logger.info("selamlarrr");
//    }
//    @Around("controllerPackagePointcut()")
//    public void aroundUser() throws Exception{
//        System.out.println("Controller package içinde işlem gerçekleşti");
//    }

}
