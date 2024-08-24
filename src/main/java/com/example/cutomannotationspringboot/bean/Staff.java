package com.example.cutomannotationspringboot.bean;


import com.example.cutomannotationspringboot.annotation.TamLength;
import com.example.cutomannotationspringboot.annotation.TamNotNull;
import com.example.cutomannotationspringboot.annotation.TamRange;
import lombok.Data;

@Data
public class Staff {
    @TamNotNull
    private String name;

    @TamRange(min = 18, max = 30)
    private int age;

    @TamLength(min = 1, max = 5)
    private String position;

    private int salary;

    public Staff(String name, int age, String position, int salary) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.salary = salary;
    }
}
