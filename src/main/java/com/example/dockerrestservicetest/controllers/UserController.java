package com.example.dockerrestservicetest.controllers;

import com.example.dockerrestservicetest.model.User;
import com.example.dockerrestservicetest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getAllUser() {
        return userService.getAllUser();
    }
    @GetMapping({"{id}"})
    public User getBookById(@PathVariable("id") int bookId) {
        return userService.findById(bookId);
    }
    @PutMapping({"{id}"})
    public void updateUser(@PathVariable int id, @RequestBody User user){
        User user1 = userService.findById(id);
        user1.setName(user.getName());
        user1.setEmeil(user.getEmeil());
        userService.save(user1);
    }
    @DeleteMapping({"{id}"})
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }
    @PostMapping
    public void createUser(@RequestBody User user){
        User saveUser = new User();
        saveUser.setName(user.getName());
        saveUser.setEmeil(user.getEmeil());
        userService.createUser(saveUser);
    }
}
