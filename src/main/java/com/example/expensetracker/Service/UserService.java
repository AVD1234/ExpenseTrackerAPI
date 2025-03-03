package com.example.expensetracker.Service;

import com.example.expensetracker.entity.User;
import com.example.expensetracker.entity.UserModel;

public interface UserService {

    public User createUser(UserModel user);

    User readUser(Long id);

    User updateUser(UserModel user, Long id);

    void deleteUser(Long id);
}
