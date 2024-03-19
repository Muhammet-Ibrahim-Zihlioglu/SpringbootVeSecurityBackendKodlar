package com.example.isyeriegitimi.controller;

import com.example.isyeriegitimi.model.User;
import com.example.isyeriegitimi.service.AuthenticationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping("/giris")
    public String  welcome(){
        return "Sayfama Hoşgeldiniz!!";
    }
    @GetMapping("/admin")
    public String  admin(){
        return "Admin sayfaya giriş yaptı!!";
    }
    private final AuthenticationService userService;
    public UserController(AuthenticationService userService) {
        this.userService = userService;
    }

    @GetMapping("/kullanicilar")
    public List<User> findAllUser(){
        return  userService.findAllUser();
    }
    @GetMapping("/kullanici/{id}")
    public Optional<User> findUserId(@PathVariable("id") int id){
        return  userService.findById(id);
    }
}


