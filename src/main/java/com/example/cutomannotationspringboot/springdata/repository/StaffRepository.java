package com.example.cutomannotationspringboot.springdata.repository;

import com.example.cutomannotationspringboot.springdata.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
}
