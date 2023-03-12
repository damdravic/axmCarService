package com.anaxim.axmCarService.mapper;

import com.anaxim.axmCarService.dto.UserRegistrationDTO;
import com.anaxim.axmCarService.model.User;
import org.springframework.stereotype.Component;

import java.util.function.Function;

public class UserRegistrationDTOMapper implements Function<User, UserRegistrationDTO>{


    @Override
    public UserRegistrationDTO apply(User user) {
        return new UserRegistrationDTO(
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getProfession());
    }
}
