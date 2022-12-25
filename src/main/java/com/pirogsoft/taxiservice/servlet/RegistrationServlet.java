package com.pirogsoft.taxiservice.servlet;

import com.pirogsoft.taxiservice.DependencyProvider;
import com.pirogsoft.taxiservice.exception.UserAlreadyExistException;
import com.pirogsoft.taxiservice.model.User;
import com.pirogsoft.taxiservice.service.login.UserService;
import com.pirogsoft.taxiservice.servlet.validation.ValidationUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationServlet extends HttpServlet {
    private final UserService userService = DependencyProvider.getInstance().getUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/registration.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> errors = new ArrayList<>();
        String login = req.getParameter(FormFields.LOGIN);
        String password = req.getParameter(FormFields.PASSWORD);
        String surname = req.getParameter(FormFields.SURNAME);
        String lastname = req.getParameter(FormFields.LASTNAME);
        String phone = req.getParameter(FormFields.PHONE);
        String email = req.getParameter(FormFields.EMAIL);
        ValidationUtils.validateLogin(errors, login);
        ValidationUtils.validatePassword(errors, password);
        ValidationUtils.validateSurname(errors, surname);
        ValidationUtils.validateLastName(errors, lastname);
        ValidationUtils.validatePhone(errors, phone);
        ValidationUtils.validateEmail(errors, email);
        User user = new User(login, surname, lastname, phone, email);
        if (errors.isEmpty()) {
            try {
                userService.createUser(user, password);
            } catch (UserAlreadyExistException e) {
                errors.add("User with login " + login + " is already exist");
            } catch (Exception e) {
                log("An error has occurred while creating a user", e);
                errors.add("Technical error has occurred");
            }
        }
        if (errors.isEmpty()) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/ordering");
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/registration.jsp");
            req.setAttribute("errors", errors);
            dispatcher.forward(req, resp);
        }
    }

    private static class FormFields {
        private static final String LOGIN = "login";
        private static final String PASSWORD = "password";
        private static final String SURNAME = "surname";
        private static final String LASTNAME = "lastname";
        private static final String PHONE = "phone";
        private static final String EMAIL = "email";
    }
}
