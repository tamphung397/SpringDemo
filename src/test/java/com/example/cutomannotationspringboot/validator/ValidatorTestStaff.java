package com.example.cutomannotationspringboot.validator;


import com.example.cutomannotationspringboot.bean.Staff;
import com.example.cutomannotationspringboot.exception.NotInLengthException;
import com.example.cutomannotationspringboot.exception.NotInRangeException;
import com.example.cutomannotationspringboot.exception.NotNullException;
import com.example.cutomannotationspringboot.validator.NotNullValidator;
import com.example.cutomannotationspringboot.validator.RequestValidator;
import com.example.cutomannotationspringboot.validator.TamLengthValidator;
import com.example.cutomannotationspringboot.validator.TamRangeValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ValidatorTestStaff {
    @TestConfiguration
    static class ValidationTestProductConfiguration{
        @Bean
        RequestValidator validator(){
            return new RequestValidator();
        }

        @Bean
        TamRangeValidator tamRangeValidator(){
            return new TamRangeValidator();
        }

        @Bean
        TamLengthValidator tamLengthValidator(){
            return new TamLengthValidator();
        }

        @Bean
        NotNullValidator notNullValidator(){
            return new NotNullValidator();
        }
    }

    @Autowired
    RequestValidator validator;
    @Test
    public void testValid() throws Exception {
        Staff staff = new Staff("John", 25, "Dev", 1000);
        validator.validate(staff);
    }

    @Test(expected = NotInRangeException.class)
    public void testInValidRangeAge() throws Exception {
        Staff staff = new Staff("John", 50, "Dev", 1000);
        validator.validate(staff);
    }

    @Test(expected = NotInLengthException.class)
    public void testInValidLengthPosition() throws Exception {
        Staff staff = new Staff("John", 25, "Developer", 1000);
        validator.validate(staff);
    }

    @Test(expected = NotNullException.class)
    public void testInValidNotNullName() throws Exception {
        Staff staff = new Staff(null, 25, "Dev", 1000);
        validator.validate(staff);
    }
}
