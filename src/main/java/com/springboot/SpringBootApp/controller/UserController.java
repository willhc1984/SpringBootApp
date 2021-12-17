package com.springboot.SpringBootApp.controller;


import com.springboot.SpringBootApp.model.User;
import com.springboot.SpringBootApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User user(@PathVariable("id") Long id){
        System.out.println("O id é:" + id);
        Optional<User> userFind = this.userRepository.findById(id);
        if(userFind.isPresent()){
            return userFind.get();
        }
        return null;
    }

    @PostMapping("/")
    public User user(@RequestBody User user){
        return this.userRepository.save(user);
    }

    @GetMapping("/list")
    public List<User> listAll(){
        return this.userRepository.findAll();
    }

}
