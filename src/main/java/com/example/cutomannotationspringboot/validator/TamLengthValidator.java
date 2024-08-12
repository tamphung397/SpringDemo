package com.example.cutomannotationspringboot.validator;

import com.example.cutomannotationspringboot.annotation.TamLength;
import com.example.cutomannotationspringboot.exception.NotInLengthException;
import com.example.cutomannotationspringboot.utils.ValidatorUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class TamLengthValidator extends AbstractValidator{

    @Override
    public void validate(Field field, Object object) throws Exception {
        if (field.isAnnotationPresent(TamLength.class)) {
            TamLength annotation = field.getAnnotation(TamLength.class);
            Object value = ValidatorUtils.getValueByField(field, object);
            if (!isValidLength((String) value, annotation.min(), annotation.max())) {
                throw new NotInLengthException("Invalid length, please input between " + annotation.min() + " and " + annotation.max());
            }
        }
    }

    public boolean isValidLength(String value, int min, int max) {
        int length = value.length();
        return length >= min && length <= max;
    }
}
