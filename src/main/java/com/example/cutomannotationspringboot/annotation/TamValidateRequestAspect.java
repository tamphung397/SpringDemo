package com.example.cutomannotationspringboot.annotation;

import com.example.cutomannotationspringboot.bean.Product;
import com.example.cutomannotationspringboot.exception.NotInLengthException;
import com.example.cutomannotationspringboot.exception.NotInRangeException;
import com.example.cutomannotationspringboot.exception.NotNullException;
import com.example.cutomannotationspringboot.validator.RequestValidator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TamValidateRequestAspect {

    @Autowired
    private RequestValidator validator;

    @Before("@annotation(TamValidateRequest)")
    public void validateRequest(JoinPoint joinPoint) throws Exception {
        Product product = (Product) joinPoint.getArgs()[0];
        validator.validate(product);
    }
}
