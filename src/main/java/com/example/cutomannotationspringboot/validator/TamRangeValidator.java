package com.example.cutomannotationspringboot.validator;

import com.example.cutomannotationspringboot.annotation.TamRange;
import com.example.cutomannotationspringboot.exception.NotInRangeException;
import com.example.cutomannotationspringboot.utils.ValidatorUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
@Component
public class TamRangeValidator extends AbstractValidator{
    @Override
    public void validate(Field field, Object object) throws Exception {
        if (field.isAnnotationPresent(TamRange.class)) {
            TamRange annotation = field.getAnnotation(TamRange.class);
            Object value = ValidatorUtils.getValueByField(field, object);
            if (!isValidRange((int) value, annotation.min(), annotation.max())) {
                throw new NotInRangeException("Invalid range, please input between " + annotation.min() + " and " + annotation.max());
            }
        }
    }

    public boolean isValidRange(int value, int min, int max) {
        return value >= min && value <= max;
    }

}
