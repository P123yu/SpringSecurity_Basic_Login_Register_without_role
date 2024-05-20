package com.down.Down.controller;

import com.down.Down.model.Login;
import com.down.Down.model.UserModel;
import com.down.Down.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<?>register(@RequestBody UserModel userModel){
        UserModel user=userServiceImpl.register(userModel);
        if(user!=null){
            return ResponseEntity.ok(user);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found");
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?>login(@RequestBody Login login){
        Authentication authentication=userServiceImpl.login(login);
        if(authentication!=null){
            return ResponseEntity.ok(authentication);
        }
        else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("LOGIN NOT AUTHORIZED");
        }
    }
}
