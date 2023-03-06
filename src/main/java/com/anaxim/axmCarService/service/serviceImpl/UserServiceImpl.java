package com.anaxim.axmCarService.service.serviceImpl;

import com.anaxim.axmCarService.model.User;
import com.anaxim.axmCarService.repository.UserRepository;
import com.anaxim.axmCarService.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private UserService userService;


    @Autowired
    public UserServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder,UserService userService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }


    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User addNewUser(User user) throws IOException{

        verifyUsernameAndEmail(user.getUsername(),user.getEmail());

        List<String> roles = new ArrayList<>();
        roles.add("USER");


        user.setPassword(passwordEncoder.encode( user.getPassword()));
        user.setUserCode((int)(Math.random()*1000));
        user.setJoinDate(new Date());
        user.setRoles(roles);
        user.setActive(true);
        user.setNotLocked(true);

        userRepository.save(user);
        return  user;

    }

    private void verifyUsernameAndEmail(String username, String email) {
        User user = userService.getUserByUsername(username);
        if(user == null){

        }


    }

    public void deleteUser(String username) throws IOException {
        User user = getUserByUsername(username);
        userRepository.deleteById(user.getId());
    }


}
