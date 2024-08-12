package com.example.cutomannotationspringboot.validator;

import com.example.cutomannotationspringboot.annotation.TamNotNull;
import com.example.cutomannotationspringboot.exception.NotNullException;
import com.example.cutomannotationspringboot.utils.ValidatorUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class NotNullValidator extends AbstractValidator {
    @Override
    public void validate(Field field, Object object) throws Exception {
        if (field.isAnnotationPresent(TamNotNull.class)) {
            Object value = ValidatorUtils.getValueByField(field, object);
            if (!isValidNotNull(value)) {
                throw new NotNullException(field.getName() + " cannot be null");
            }
        }
    }

    public boolean isValidNotNull(Object value) {
        return value != null;
    }
}
