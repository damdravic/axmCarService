package com.anaxim.axmCarService.service.serviceImpl;

import com.anaxim.axmCarService.model.User;
import com.anaxim.axmCarService.repository.UserRepository;
import com.anaxim.axmCarService.service.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
}
