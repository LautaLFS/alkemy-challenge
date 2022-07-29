package com.alkemy.disney.Security.Service;

import com.alkemy.disney.Security.Dto.UserDto;
import com.alkemy.disney.Security.Entity.UserEntity;
import com.alkemy.disney.Security.Repository.UserRepository;
import com.alkemy.disney.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsCustomService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private EmailService emailService;

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
        userEntity.setPassword(encoder.encode(userDto.getPassword()));
        userEntity = this.userRepository.save(userEntity);
        if (userRepository.findByUsername(userEntity.getUsername()) != null) {
            emailService.sendWelcomeEmailTo(userEntity.getUsername());
        }

        return userEntity != null;
    }
}
