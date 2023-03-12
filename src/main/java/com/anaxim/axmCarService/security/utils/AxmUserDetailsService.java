package com.anaxim.axmCarService.security.utils;

import com.anaxim.axmCarService.model.User;
import com.anaxim.axmCarService.repository.UserRepository;
import com.anaxim.axmCarService.exceptions.ExceptionsHandling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AxmUserDetailsService extends ExceptionsHandling implements AxmUserService, UserDetailsService  {


    private static final String NO_USERNAME_FOUND_BY_NAME = "nu e nume";
    @Autowired
    private UserRepository userRepository;


    public AxmUserDetailsService() {
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user  = userRepository.findUserByUsername(username);

        if(user == null){


            throw new UsernameNotFoundException("la dracu   ... ceva nu i bine");
        }




            UserPrincipal userPrincipal = new UserPrincipal(user);
            System.out.println(userPrincipal.toString());
            return userPrincipal;



    }


}
