package com.anaxim.axmCarService.security.resouce;

import com.anaxim.axmCarService.user.dao.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class SecurityResource {

    @PostMapping("/register")
    public String getTest(){
        return "Work !!";
    }


    @PostMapping("/login")
    public ResponseEntity<User> login(@ResponseBody User user){
        authenticate(user.getUser)
    }


    @GetMapping("/test")
    public String test(){
        return "Test working !!!";
    }

}



