package com.myclass.validator;

import com.myclass.dto.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return UserDto.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        UserDto userDto =(UserDto) obj;
        if(userDto.getPassword().length()< 6 ){
            errors.rejectValue("password", "Length", "Password must be at least 6 characters");
        }
        if(!userDto.getPassword().equals(userDto.getConfirmPassword())){
            errors.rejectValue("password", "Match", "Password must match");
        }
    }
}
