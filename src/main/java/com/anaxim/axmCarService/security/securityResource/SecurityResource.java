package com.anaxim.axmCarService.security.securityResource;

import com.anaxim.axmCarService.model.User;
import com.anaxim.axmCarService.security.utils.JwtTokenProvider;
import com.anaxim.axmCarService.security.utils.UserPrincipal;
import com.anaxim.axmCarService.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import  static com.anaxim.axmCarService.security.constant.SecurityConstant.*;
import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping("/auth")
public class SecurityResource {

    public AuthenticationManager authenticationManager;
    public JwtTokenProvider jwtTokenProvider;
    public UserService userService;

     @Autowired
    public SecurityResource(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping("/register")
    public String getTest() {
        return "Work !!";
    }

    @PostMapping("/add")
    public ResponseEntity<User> add(@RequestParam("firstName") String firstName,
                                    @RequestParam("lastName") String lastName,
                                    @RequestParam("username") String username,
                                    @RequestParam("email") String email,
                                    @RequestParam("password") String password,
                                    @RequestParam("profileImageUrl") String piu,
                                    @RequestParam("profession") String profession) throws IOException {
        User user = new User(firstName,lastName,username,email,password,profession);
        userService.addNewUser(user);

        return new ResponseEntity<>(user,OK);

    }



    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user){


       authenticate(user.getUsername(),user.getPassword());

       User userLogin = userService.getUserByUsername(user.getUsername());

       UserPrincipal userPrincipal = new UserPrincipal(userLogin);
       HttpHeaders jwtHeader = getJwtHeader(userPrincipal);

        return new ResponseEntity<>(userLogin,jwtHeader,OK);



    }

    private HttpHeaders getJwtHeader(UserPrincipal userPrincipal) {
        System.out.println("in getJwtHeader");
        HttpHeaders httpHeader = new HttpHeaders();
         httpHeader.add(JWT_TOKEN_HEADER,jwtTokenProvider.generateToken(userPrincipal));
        return httpHeader;

    }

    private void authenticate(String username, String password) throws UsernameNotFoundException {
        System.out.println("in authenticate");
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));


    }


    @GetMapping("/test")
    public String test(){
        return "Test working !!!";
    }

}



