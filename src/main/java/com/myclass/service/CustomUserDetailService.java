package com.myclass.service;

import com.myclass.convert.UserConvert;
import com.myclass.dto.UserDto;
import com.myclass.entity.User;
import com.myclass.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserConvert userConvert;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        UserDto userDto = userConvert.toDto(user);
        if(userDto == null){
             new UsernameNotFoundException("User not found");
        }
        return userDto;
    }
    @Transactional
    public UserDto loadUserById(long id){
        User user = userRepository.findById(id);
        UserDto userDto = userConvert.toDto(user);
        if(userDto == null){
            new UsernameNotFoundException("User not found");
        }
        return userDto;
    }

}
