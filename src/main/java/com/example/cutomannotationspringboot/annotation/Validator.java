package com.example.cutomannotationspringboot.annotation;


import com.example.cutomannotationspringboot.exception.NotInLengthException;
import com.example.cutomannotationspringboot.exception.NotInRangeException;
import com.example.cutomannotationspringboot.exception.NotNullException;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
@Component
public class Validator {
    public void validate(Object object) throws NoSuchFieldException, IllegalAccessException, NotInLengthException, NotInRangeException, NotNullException {
        Class<?> clazz = object.getClass();
        Field[] field = clazz.getDeclaredFields();
        for (Field f : field) {
            if (f.isAnnotationPresent(TamLength.class)) {
                TamLength annotation = clazz.getDeclaredField(f.getName()).getAnnotation(TamLength.class);
                f.setAccessible(true);
                Object value = f.get(object);
                if (!isValidLength((String) value, annotation.min(), annotation.max())) {
                    throw new NotInLengthException("Invalid length, please input between " + annotation.min() + " and " + annotation.max());
                }
            }

            if (f.isAnnotationPresent(TamRange.class)) {
                TamRange annotation = clazz.getDeclaredField(f.getName()).getAnnotation(TamRange.class);
                f.setAccessible(true);
                Object value = f.get(object);
                if (!isValidRange((int) value, annotation.min(), annotation.max())) {
                    throw new NotInRangeException("Invalid range, please input between " + annotation.min() + " and " + annotation.max());
                }
            }

            if (f.isAnnotationPresent(TamNotNull.class)) {
                f.setAccessible(true);
                Object value = f.get(object);
                if (!isValidNotNull(value)) {
                    throw new NotNullException(f.getName() + " cannot be null");
                }
            }

        }
    }

    public boolean isValidLength(String value, int min, int max) {
        int length = value.length();
        return length >= min && length <= max;
    }

    public boolean isValidRange(int value, int min, int max) {
        return value >= min && value <= max;
    }

    public boolean isValidNotNull(Object value) {
        return value != null;
    }
}
