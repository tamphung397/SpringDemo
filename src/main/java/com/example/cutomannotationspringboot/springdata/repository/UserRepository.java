package com.example.cutomannotationspringboot.springdata.repository;

import com.example.cutomannotationspringboot.springdata.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
