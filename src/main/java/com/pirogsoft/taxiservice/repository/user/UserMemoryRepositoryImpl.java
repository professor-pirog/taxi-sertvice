package com.pirogsoft.taxiservice.repository.user;

import com.pirogsoft.taxiservice.exception.UserAlreadyExistException;
import com.pirogsoft.taxiservice.model.Role;
import com.pirogsoft.taxiservice.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserMemoryRepositoryImpl implements UserRepository {

    private final List<UserWithPassword> usersWithPassword = new ArrayList<>();

    public UserMemoryRepositoryImpl() {
        User user = new User("pirog", "Andrey", "Ivanov", "+380980000000", "pidaras@hui.com");
        user.addRole(Role.USER);
        usersWithPassword.add(new UserWithPassword(user, "papka"));
    }

    @Override
    public Optional<User> findUser(String login, String password) {
        return usersWithPassword
                .stream()
                .filter(userWithPassword ->
                        userWithPassword.user.getLogin().equals(login)
                                && userWithPassword.password.equals(password)).map(it -> it.user).findFirst();
    }

    @Override
    public synchronized void createUser(User user, String password) {
        if (usersWithPassword.stream().anyMatch(it -> it.user.getLogin().equals(user.getLogin())))
            throw new UserAlreadyExistException(user.getLogin());
        usersWithPassword.add(new UserWithPassword(user, password));
    }

    private static class UserWithPassword {
        private final User user;
        private final String password;

        public UserWithPassword(User user, String password) {
            this.user = user;
            this.password = password;
        }
    }
}
