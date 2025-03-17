package com.example.expensetracker.Service;

import com.example.expensetracker.entity.User;
import com.example.expensetracker.entity.UserModel;

public interface UserService {

    public User createUser(UserModel user);

    User readUser();

    User updateUser(UserModel user);

    void deleteUser();

    User getLoggedInUser();
}
