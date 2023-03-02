package com.anaxim.axmCarService.service.serviceImpl;

import com.anaxim.axmCarService.service.serviceInterface.AxmUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AxmUserDetailsService implements AxmUserService, UserDetailsService {



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }


}
