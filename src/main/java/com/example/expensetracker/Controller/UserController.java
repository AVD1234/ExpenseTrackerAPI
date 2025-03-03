package com.example.expensetracker.Controller;

import com.example.expensetracker.Service.UserService;
import com.example.expensetracker.entity.User;
import com.example.expensetracker.entity.UserModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/users/{userid}")
    public ResponseEntity<User> readUser(@PathVariable Long userid) {
        return new ResponseEntity<User>(userService.readUser(userid), HttpStatus.OK);
    }

    @PutMapping("/users/{userid}")
    public ResponseEntity<User> updateUser(@RequestBody UserModel user, @PathVariable Long userid) {
        return new ResponseEntity<User>(userService.updateUser(user, userid), HttpStatus.OK);
    }

    @DeleteMapping("/users/{userid}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long userid) {
        userService.deleteUser(userid);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

}
