package com.example.cutomannotationspringboot.springdata;

import com.example.cutomannotationspringboot.dto.staff.CreateStaffDto;
import com.example.cutomannotationspringboot.service.StaffService;
import com.example.cutomannotationspringboot.springdata.entity.Staff;
import com.example.cutomannotationspringboot.springdata.entity.User;
import com.example.cutomannotationspringboot.springdata.repository.StaffRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//@SpringBootTest
//@RunWith(SpringRunner.class)
public class SpringDataTest {
    @Autowired
    private StaffService staffService;

    @Test
    public void createStaff() throws IOException {
//        System.out.println("oke123");
//        Files.createDirectory(Paths.get("/tmp"));
        Files.createTempFile(Paths.get("/tmps"), null, null);
    }
}
