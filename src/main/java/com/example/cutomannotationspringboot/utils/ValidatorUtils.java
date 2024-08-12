package com.example.cutomannotationspringboot.utils;

import java.lang.reflect.Field;

public class ValidatorUtils {
    public static Object getValueByField(Field field, Object object) throws IllegalAccessException {
        field.setAccessible(true);
        return field.get(object);
    }
}
