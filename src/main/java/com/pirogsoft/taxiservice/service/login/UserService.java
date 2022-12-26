package com.pirogsoft.taxiservice.service.login;

import com.pirogsoft.taxiservice.DependencyProvider;
import com.pirogsoft.taxiservice.model.Role;
import com.pirogsoft.taxiservice.model.User;
import com.pirogsoft.taxiservice.repository.user.UserRepository;

import java.util.Optional;

public class UserService {

    private final UserRepository userRepository = DependencyProvider.getInstance().getUserRepository();

    public Optional<User> findUser(String login, String password) {
        return userRepository.findUser(login, password);
    }

    public void createUser(User user, String password) {
        user.addRole(Role.USER);
        userRepository.createUser(user, password);
    }
}
