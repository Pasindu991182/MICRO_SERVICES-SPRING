package com.saloon.pasindu.service;

import com.saloon.pasindu.exeption.UserException;
import com.saloon.pasindu.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User getUserById(Long id) throws UserException;
    List<User> getAllUsers() throws UserException;
    String deleteUser(Long id) throws UserException;
    User updateUser(Long id, User user) throws UserException; // Added id parameter
}