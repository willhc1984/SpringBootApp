package com.springboot.SpringBootApp.repository;

import com.springboot.SpringBootApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
