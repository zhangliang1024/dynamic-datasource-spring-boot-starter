package com.zhliang.pzy.dynamic.datasource.aop;

import com.zhliang.pzy.dynamic.datasource.context.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {


    @Pointcut("!@annotation(com.zhliang.pzy.dynamic.datasource.annotation.Master)"+
            "&&(execution(* com..*Impl.select*(..))"+
            "|| execution(* com..*Impl.get*(..))" +
            "|| execution(* com..*Impl.find*(..)))")
    public void readPointcut(){
    }

    @Pointcut("@annotation(com.zhliang.pzy.dynamic.datasource.annotation.Master) " +
            "|| execution(* com..*Impl.insert*(..)) " +
            "|| execution(* com..*Impl.add*(..)) " +
            "|| execution(* com..*Impl.update*(..)) " +
            "|| execution(* com..*Impl.edit*(..)) " +
            "|| execution(* com..*Impl.delete*(..)) " +
            "|| execution(* com..*Impl.remove*(..))"+
            "|| execution(* com..*Impl.save*(..))")
    public void writePointcut(){
    }

    @Before("readPointcut()")
    public void read(){
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write(){
        DBContextHolder.master();
    }

}
