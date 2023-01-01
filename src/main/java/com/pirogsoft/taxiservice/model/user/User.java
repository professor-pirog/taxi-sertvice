package com.pirogsoft.taxiservice.model.user;

import java.util.HashSet;
import java.util.Set;

public class User {
    String login;
    String surname;
    String lastname;
    String phone;
    String email;
    Set<Role> roles = new HashSet<>();

    public User(String login, String surname, String lastname, String phone, String email) {
        this.login = login;
        this.surname = surname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public String getSurname() {
        return surname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void addRole(Role role) {
        roles.add(role);
    }
}
