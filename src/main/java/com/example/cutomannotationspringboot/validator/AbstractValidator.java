package com.example.cutomannotationspringboot.validator;

import java.lang.reflect.Field;

public abstract class AbstractValidator {
    public abstract void validate(Field field, Object object) throws Exception;
}
