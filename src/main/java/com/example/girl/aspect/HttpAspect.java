package com.example.girl.aspect;

import com.example.girl.emums.ResultEnum;
import com.example.girl.exception.GirlException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.girl.controller.GirlController.*(..)))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
        //url
        logger.info("url={}", httpServletRequest.getRequestURI());

        //method
        logger.info("method={}", httpServletRequest.getMethod());

        //ip
        logger.info("ip={}", httpServletRequest.getRemoteAddr());

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        logger.info("222");
    }


    //当执行删除girl操作后girl对象不存在，如果执行下面这方法就会抛空指针异常
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) throws GirlException{
           if(object != null){
               logger.info("response={}", object.toString());
           }else {
               throw new GirlException(ResultEnum.UNEXIST_ERROR);
           }
    }
}
