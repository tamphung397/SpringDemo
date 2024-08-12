package com.example.cutomannotationspringboot.validator;


import com.example.cutomannotationspringboot.exception.NotInLengthException;
import com.example.cutomannotationspringboot.exception.NotInRangeException;
import com.example.cutomannotationspringboot.exception.NotNullException;
import com.example.cutomannotationspringboot.validator.NotNullValidator;
import com.example.cutomannotationspringboot.validator.TamLengthValidator;
import com.example.cutomannotationspringboot.validator.TamRangeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class RequestValidator {
    @Autowired
    TamLengthValidator tamLengthValidator;

    @Autowired
    TamRangeValidator tamRangeValidator;

    @Autowired
    NotNullValidator notNullValidator;

    public void validate(Object object) throws Exception {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            tamLengthValidator.validate(field, object);
            tamRangeValidator.validate(field, object);
            notNullValidator.validate(field, object);
        }
    }
}
