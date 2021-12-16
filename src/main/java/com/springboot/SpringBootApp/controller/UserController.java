package com.springboot.SpringBootApp.controller;


import com.springboot.SpringBootApp.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();


    @GetMapping("/{id}")
    public User user(@PathVariable("id") Long id){
        System.out.println("O id é:" + id);
        Optional<User> userFind = users.stream().filter(user -> user.getId() == id).findFirst();
        if(userFind.isPresent()){
            return userFind.get();
        }
        return null;
    }

    @PostMapping("/")
    public User user(@RequestBody User user){
        users.add(user);
        return user;
    }

    @GetMapping("/list")
    public List<User> listAll(){
        return users;
    }

}
