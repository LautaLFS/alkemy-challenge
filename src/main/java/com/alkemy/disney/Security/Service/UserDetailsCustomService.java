package com.alkemy.disney.Security.Service;

import com.alkemy.disney.Security.Dto.UserDto;
import com.alkemy.disney.Security.Entity.UserEntity;
import com.alkemy.disney.Security.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsCustomService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(userName);
        if (userEntity == null){
            throw new UsernameNotFoundException("Username not found");
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), Collections.emptyList());
    }
    public boolean save(UserDto userDto){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDto.getUsername());
        userEntity.setPassword(userDto.getPassword());
        userEntity = this.userRepository.save(userEntity);

        return userEntity != null;
    }
}
