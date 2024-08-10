package com.example.cutomannotationspringboot;


import com.example.cutomannotationspringboot.annotation.Validator;
import com.example.cutomannotationspringboot.bean.Product;
import com.example.cutomannotationspringboot.exception.NotInLengthException;
import com.example.cutomannotationspringboot.exception.NotInRangeException;
import com.example.cutomannotationspringboot.exception.NotNullException;
import org.junit.Test;


public class ValidatorTestProduct {
    @Test
    public void testValid() throws NotInLengthException, NoSuchFieldException, NotNullException, NotInRangeException, IllegalAccessException {
        Product product = new Product("Iphone", 4000, "Phone");
        Validator validator = new Validator();
        validator.validate(product);
    }

    @Test(expected = NotInRangeException.class)
    public void testInValidRangePrice() throws NotInLengthException, NoSuchFieldException, NotNullException, NotInRangeException, IllegalAccessException {
        Product product = new Product("Iphone", 1000, "Phone");
        Validator validator = new Validator();
        validator.validate(product);
    }

    @Test(expected = NotInLengthException.class)
    public void testInValidLengthCategory() throws NotInLengthException, NoSuchFieldException, NotNullException, NotInRangeException, IllegalAccessException {
        Product product = new Product("Iphone", 4000, "SmartPhone");
        Validator validator = new Validator();
        validator.validate(product);
    }

    @Test(expected = NotNullException.class)
    public void testInValidNotNullName() throws NotInLengthException, NoSuchFieldException, NotNullException, NotInRangeException, IllegalAccessException {
        Product product = new Product(null, 4000, "SmartPhone");
        Validator validator = new Validator();
        validator.validate(product);
    }
}
