package com.pirogsoft.taxiservice.service.login;

import com.pirogsoft.taxiservice.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findUser(String login, String password);

    void createUser(User user, String password);
}
