package com.pirogsoft.taxiservice.service;

import com.pirogsoft.taxiservice.model.user.Role;
import com.pirogsoft.taxiservice.model.user.User;
import com.pirogsoft.taxiservice.repository.user.UserRepository;

import java.util.Optional;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUser(String login, String password) {
        return userRepository.findUser(login, password);
    }

    public void createUser(User user, String password) {
        user.addRole(Role.USER);
        userRepository.createUser(user, password);
    }
}
