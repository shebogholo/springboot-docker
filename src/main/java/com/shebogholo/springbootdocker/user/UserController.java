package com.shebogholo.springbootdocker.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("{userId}")
    public Optional<User> getUserById(@PathVariable("userId") Long userId){
        return userService.getUserById(userId);
    }

    @DeleteMapping("{userId}")
    public void deleteUserById(@PathVariable("userId") Long userId){
        userService.deleteUserById(userId);
    }

    @PutMapping("{userId}")
    public void updateUser(@PathVariable("userId") Long userId, @RequestBody User user){
        userService.updateUser(userId, user);
    }
}