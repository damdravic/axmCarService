package com.anaxim.axmCarService.repository;

import com.anaxim.axmCarService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User,Long>{

    User findUserByUsername(String username);

    User findUserByMail(String mail) ;

}
