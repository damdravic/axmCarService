package com.anaxim.axmCarService.service.serviceInterface;

import com.anaxim.axmCarService.dto.UserRegistrationDTO;
import com.anaxim.axmCarService.exceptions.EmailExistException;
import com.anaxim.axmCarService.model.User;
import com.anaxim.axmCarService.exceptions.UsernameExistException;

import java.io.IOException;
import java.util.List;

public interface UserService {

    User getUserByUsername(String username);

    User getUserByEmail(String email);

    List<User> findAllUser();


    User addNewUser(UserRegistrationDTO userRegistrationDTO) throws IOException, UsernameExistException, EmailExistException, IllegalAccessException;


}
