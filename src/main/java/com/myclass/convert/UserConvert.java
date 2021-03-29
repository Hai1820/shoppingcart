package com.myclass.convert;

import com.myclass.dto.UserDto;
import com.myclass.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConvert {
    public User toEntity(UserDto userDto){
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setProfile(userDto.getProfile());
        user.setIntro(userDto.getIntro());
        user.setMobile(userDto.getMobile());
        user.setConfirmPassword(userDto.getConfirmPassword());
        return user;
    }
    public UserDto toDto(User user){
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setProfile(user.getProfile());
        userDto.setIntro(user.getIntro());
        userDto.setMobile(user.getMobile());
        userDto.setConfirmPassword(user.getConfirmPassword());
        return userDto;
    }
}
