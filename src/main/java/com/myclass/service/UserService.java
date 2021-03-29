package com.myclass.service;

import com.myclass.dto.UserDto;
import com.myclass.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User saveUser(UserDto userDto);
}
