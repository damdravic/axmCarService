package com.anaxim.axmCarService.security.securityResource;

import com.anaxim.axmCarService.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/security")
public class SecurityResource {

    public AuthenticationManager authenticationManager;


    @PostMapping("/register")
    public String getTest(){
        return "Work !!";
    }


    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user){
       authenticate(user.getUsername(),user.getPassword());
       return null;

    }

    private void authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
    }


    @GetMapping("/test")
    public String test(){
        return "Test working !!!";
    }

}



