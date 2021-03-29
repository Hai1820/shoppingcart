package com.myclass.service.impl;

import com.myclass.convert.UserConvert;
import com.myclass.dto.UserDto;
import com.myclass.entity.User;
import com.myclass.exception.UsernameAlreadyExistsException;
import com.myclass.repository.UserRepository;
import com.myclass.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserConvert userConvert;

    @Override
    public User saveUser(UserDto userDto) {
        try {
            userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
//            username need to be unique


            userDto.setEmail(userDto.getEmail());
            userDto.setConfirmPassword("");
            User user = userConvert.toEntity(userDto);
            return userRepository.save(user);
        }catch (Exception e){
             throw  new UsernameAlreadyExistsException("Username '" + userDto.getEmail()+"' already exists ");
        }

    }


}
