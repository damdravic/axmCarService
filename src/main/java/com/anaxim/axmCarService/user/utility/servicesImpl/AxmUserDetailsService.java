package com.anaxim.axmCarService.user.utility.servicesImpl;

import com.anaxim.axmCarService.user.utility.services.AxmUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AxmUserDetailsService implements AxmUserService, UserDetailsService {



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }


}
