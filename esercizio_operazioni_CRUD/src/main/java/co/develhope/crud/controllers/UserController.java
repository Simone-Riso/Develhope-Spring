package co.develhope.crud.controllers;

import co.develhope.crud.entities.User;
import co.develhope.crud.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping
    public User createUser(@RequestBody User user) {
        User userSaved = userRepo.saveAndFlush(user);
        return userSaved;
    }

    @GetMapping
    public List<User> getUser() {
        List<User> users = userRepo.findAll();
        return users;
    }

}

