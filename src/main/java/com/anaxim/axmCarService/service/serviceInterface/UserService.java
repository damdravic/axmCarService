package com.anaxim.axmCarService.service.serviceInterface;

import com.anaxim.axmCarService.model.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    User getUserByUsername(String username);

    User getUserByEmail(String email);

    List<User> findAllUser();


    User addNewUser(User user) throws IOException;


}
