package com.example.cutomannotationspringboot.controller;

import com.example.cutomannotationspringboot.dto.staff.CreateStaffDto;
import com.example.cutomannotationspringboot.dto.staff.StaffDto;
import com.example.cutomannotationspringboot.dto.staff.UpdateStaffDto;
import com.example.cutomannotationspringboot.exception.SpringDemoException;
import com.example.cutomannotationspringboot.service.StaffService;
import com.example.cutomannotationspringboot.validator.annotation.TamValidateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping("/create")
    @TamValidateRequest
    public ResponseEntity<StaffDto> createStaff(@RequestBody CreateStaffDto createStaffDto){
       StaffDto staffDtoResponse = staffService.createStaff(createStaffDto);
       return ResponseEntity.ok(staffDtoResponse);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StaffDto>> getAllStaff(){
        List<StaffDto> staffDtoList = staffService.getAllStaff();
        return ResponseEntity.ok(staffDtoList);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<StaffDto> getStaff(@PathVariable int id) throws SpringDemoException {
        StaffDto staffDto = staffService.getStaffById(id);
        return ResponseEntity.ok(staffDto);
    }

    @PutMapping("/update")
    public ResponseEntity<StaffDto> updateStaff(@RequestBody UpdateStaffDto updateStaffDto) throws SpringDemoException {
        StaffDto staffDtoResponse = staffService.updateStaff(updateStaffDto);
        return ResponseEntity.ok(staffDtoResponse);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStaff(@PathVariable int id) throws SpringDemoException {
        staffService.deleteStaff(id);
    }
}
