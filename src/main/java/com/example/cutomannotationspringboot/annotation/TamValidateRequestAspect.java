package com.example.cutomannotationspringboot.annotation;

import com.example.cutomannotationspringboot.bean.Product;
import com.example.cutomannotationspringboot.exception.NotInLengthException;
import com.example.cutomannotationspringboot.exception.NotInRangeException;
import com.example.cutomannotationspringboot.exception.NotNullException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TamValidateRequestAspect {

    @Autowired
    private Validator validator;

    @Before("@annotation(TamValidateRequest)")
    public void validateRequest(JoinPoint joinPoint) throws NotInLengthException, NoSuchFieldException, NotNullException, NotInRangeException, IllegalAccessException {
        Product product = (Product) joinPoint.getArgs()[0];
        validator.validate(product);
    }
}
