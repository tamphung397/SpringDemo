package com.example.cutomannotationspringboot;


import com.example.cutomannotationspringboot.annotation.Validator;
import com.example.cutomannotationspringboot.bean.Staff;
import com.example.cutomannotationspringboot.exception.NotInLengthException;
import com.example.cutomannotationspringboot.exception.NotInRangeException;
import com.example.cutomannotationspringboot.exception.NotNullException;
import org.junit.Test;


public class ValidatorTestStaff {
    @Test
    public void testValid() throws NotInLengthException, NoSuchFieldException, NotNullException, NotInRangeException, IllegalAccessException {
        Staff staff = new Staff("John", 25, "Dev", 1000);
        Validator validator = new Validator();
        validator.validate(staff);
    }

    @Test(expected = NotInRangeException.class)
    public void testInValidRangeAge() throws NotInLengthException, NoSuchFieldException, NotNullException, NotInRangeException, IllegalAccessException {
        Staff staff = new Staff("John", 50, "Dev", 1000);
        Validator validator = new Validator();
        validator.validate(staff);
    }

    @Test(expected = NotInLengthException.class)
    public void testInValidLengthPosition() throws NotInLengthException, NoSuchFieldException, NotNullException, NotInRangeException, IllegalAccessException {
        Staff staff = new Staff("John", 25, "Developer", 1000);
        Validator validator = new Validator();
        validator.validate(staff);
    }

    @Test(expected = NotNullException.class)
    public void testInValidNotNullName() throws NotInLengthException, NoSuchFieldException, NotNullException, NotInRangeException, IllegalAccessException {
        Staff staff = new Staff(null, 25, "Dev", 1000);
        Validator validator = new Validator();
        validator.validate(staff);
    }
}
