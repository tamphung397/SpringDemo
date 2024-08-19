package com.example.cutomannotationspringboot.springdata;

import com.example.cutomannotationspringboot.springdata.entity.Staff;
import com.example.cutomannotationspringboot.springdata.entity.User;
import com.example.cutomannotationspringboot.springdata.repository.StaffRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringDataTest {
    @Autowired
    private StaffRepository staffRepository;

    @Test
    public void createStaff(){
        User user = new User("test@gmail.com","test","1234");
        Staff staff = new Staff("staff1","Dev",4000);
        staff.setUser(user);
        staffRepository.save(staff);
    }
}
