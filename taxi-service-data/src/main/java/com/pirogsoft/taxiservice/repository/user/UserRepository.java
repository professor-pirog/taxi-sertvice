package com.pirogsoft.taxiservice.repository.user;

import com.pirogsoft.taxiservice.model.user.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findUser(String login, String password);

    void createUser(User user, String password);
}
