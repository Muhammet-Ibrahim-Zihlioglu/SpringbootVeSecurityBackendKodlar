package com.example.isyeriegitimi.controller;

import com.example.isyeriegitimi.dto.UserDto;
import com.example.isyeriegitimi.dto.UserRequest;
import com.example.isyeriegitimi.dto.UserResponse;
import com.example.isyeriegitimi.model.User;
import com.example.isyeriegitimi.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    //kullanıcı kayıt işlemini yapıyoruz.
    @PostMapping("/save")
    public ResponseEntity<UserResponse> save(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(authenticationService.save(userDto));
    }
    @GetMapping("/admin")
    public String  admin(){
        return "Admin sayfaya giriş yaptı!!";
    }
    //Kullanıcının olup olmadığını kontrol ediyoruz.
    @PostMapping("/auth")
    public ResponseEntity<UserResponse> auth(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(authenticationService.auth(userRequest));
    }
    @PutMapping("/update")
    public ResponseEntity<UserResponse> updateUser(@RequestBody User users){
        return ResponseEntity.ok(authenticationService.updateUser(users));
    }
    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable("id") int id){
        authenticationService.deleteUser(id);
    }

}

