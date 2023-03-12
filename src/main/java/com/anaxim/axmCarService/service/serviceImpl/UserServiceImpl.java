package com.anaxim.axmCarService.service.serviceImpl;

import com.anaxim.axmCarService.dto.UserRegistrationDTO;
import com.anaxim.axmCarService.exceptions.EmailExistException;
import com.anaxim.axmCarService.model.User;
import com.anaxim.axmCarService.repository.UserRepository;
import com.anaxim.axmCarService.exceptions.UsernameExistException;
import com.anaxim.axmCarService.service.serviceInterface.UserService;
import org.hibernate.NonUniqueObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.RecordComponent;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

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

    public User addNewUser(UserRegistrationDTO userRegistrationDTO) throws IOException, UsernameExistException, EmailExistException, IllegalAccessException {
        verifyFieldsLength(userRegistrationDTO);
        verifyUsernameAndEmail(null, userRegistrationDTO.username(), userRegistrationDTO.email());

        List<String> roles = new ArrayList<>();
        roles.add("USER");
        int userCode = (int) Math.random() * 1000;

        User user = new User(userCode,
                userRegistrationDTO.firstName(),
                userRegistrationDTO.lastname(),
                userRegistrationDTO.username(),
                userRegistrationDTO.email(),
                passwordEncoder.encode(userRegistrationDTO.password()),
                null,
                new Date(),
                null,
                null,
                userRegistrationDTO.profession(), roles, true, true
        );

        userRepository.save(user);
        return user;

    }

    private void verifyFieldsLength(UserRegistrationDTO userRegistrationDTO) throws UsernameExistException, IllegalAccessException {

       List<String> fields = Arrays.asList(userRegistrationDTO.email(),
               userRegistrationDTO.firstName(),
               userRegistrationDTO.lastname(),
               userRegistrationDTO.password(),
               userRegistrationDTO.username(),
               userRegistrationDTO.profession());

         for(String f : fields){
             if(f == null || !StringUtils.hasLength(f)){
                 throw new UsernameExistException("Aici nu ai completat tot !!!");
             }

         }

    }

    private void verifyUsernameAndEmail(String currentUsername, String username, String email) throws UsernameExistException, EmailExistException, NonUniqueObjectException {
        // v1
        User userByUsername = userRepository.findUserByUsername(username);
        User userByEmail = userRepository.findUserByEmail(email);

        if (StringUtils.hasLength(currentUsername)) {
            User currentUser = userRepository.findUserByUsername(currentUsername);

               if (currentUser == null) {
                  throw new UsernameNotFoundException("User not exist");}
                if (userByUsername != null && !currentUser.getId().equals(userByUsername.getId())) {
                    throw new UsernameExistException("");
                }
                if (userByEmail != null && !currentUser.getId().equals(userByEmail.getId())) {
                    throw new EmailExistException("");
                }

            } else {
                if (userByUsername != null) {
                    throw new UsernameExistException("Username is taken ");
                }
                if (userByEmail != null) {
                    throw new EmailExistException("This email is already used in owr system.");
                }


            }


        }





    public void deleteUser(String username) {
        User user = getUserByUsername(username);
        userRepository.deleteById(user.getId());
    }


}
