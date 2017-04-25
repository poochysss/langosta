package com.ppg.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.ppg.domain.User;
import com.ppg.domain.UserJson;
import com.ppg.services.security.UserDetailsImpl;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class JsonUserToUser implements Converter<UserJson, User> {
    @Override
    public User convert(UserJson userjson) {
    	User user = new User();

        if (userjson != null) {
          user.setUsername(userjson.getEmail());
          user.setPassword(userjson.getPassword());
          user.setEncryptedPassword(userjson.getPassword());
        }

        return user;
    }
}
