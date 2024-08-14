package com.example.cutomannotationspringboot.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public abstract class AbstractValidator<T, A extends Annotation> {
    public void validate(Field field, Object object) throws Exception {
        if (field.isAnnotationPresent(getClazz())) {
            A annotation = field.getAnnotation(getClazz());
            field.setAccessible(true);
            T value = (T) field.get(object);
            if (!isValid(value, annotation)) {
                throw getException(field, annotation);
            }
        }
    }

    public abstract Class<A> getClazz();

    public abstract boolean isValid(T value, A annotation);

    public abstract Exception getException(Field field,A annotation);
}
