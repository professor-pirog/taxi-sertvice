package com.pirogsoft.taxiservice;

import com.pirogsoft.taxiservice.repository.user.UserMemoryRepositoryImpl;
import com.pirogsoft.taxiservice.repository.user.UserRepository;
import com.pirogsoft.taxiservice.service.login.UserService;
import com.pirogsoft.taxiservice.service.login.UserServiceImpl;

public class DependencyProvider {

    private static DependencyProvider instance;

    private UserService userService;

    private UserRepository userRepository;

    private DependencyProvider() {
    }

    public static synchronized DependencyProvider getInstance() {
        if (instance == null) {
            instance = new DependencyProvider();
        }
        return instance;
    }

    public synchronized UserService getUserService() {
        if (userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }

    public synchronized UserRepository getUserRepository() {
        if (userRepository == null) {
            userRepository = new UserMemoryRepositoryImpl();
        }
        return userRepository;
    }
}
