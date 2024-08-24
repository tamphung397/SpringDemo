package com.example.cutomannotationspringboot.validator;


import com.example.cutomannotationspringboot.bean.Product;
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
public class ValidatorTestProduct {

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
        Product product = new Product("Iphone", 4000, "Phone");
        validator.validate(product);
    }

    @Test(expected = NotInRangeException.class)
    public void testInValidRangePrice() throws Exception {
        Product product = new Product("Iphone", 1000, "Phone");
        validator.validate(product);
    }

    @Test(expected = NotInLengthException.class)
    public void testInValidLengthCategory() throws Exception {
        Product product = new Product("Iphone", 4000, "SmartPhone");
        validator.validate(product);
    }

    @Test(expected = NotNullException.class)
    public void testInValidNotNullName() throws Exception {
        Product product = new Product(null, 4000, "SmartPhone");
        validator.validate(product);
    }
}