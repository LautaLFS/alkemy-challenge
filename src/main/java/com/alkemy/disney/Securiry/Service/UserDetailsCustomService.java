package com.alkemy.disney.Securiry.Service;

import com.alkemy.disney.Securiry.Entity.UserEntity;
import com.alkemy.disney.Securiry.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsCustomService extends UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserName(username);
        if (userEntity == null){
            throw new UsernameNotFoundException("Username not found");
        }
        return new User;
    }
}
