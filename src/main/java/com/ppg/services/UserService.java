package com.ppg.services;

import com.ppg.domain.User;
import com.ppg.domain.UserJson;

public interface UserService extends CRUDService<User> {

    User findByUsername(String username);

}
