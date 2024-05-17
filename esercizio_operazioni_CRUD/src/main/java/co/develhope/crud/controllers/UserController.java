package co.develhope.crud.controllers;

import co.develhope.crud.entities.User;
import co.develhope.crud.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        User userSaved = userRepo.saveAndFlush(user);
        return userSaved;
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        List<User> users = userRepo.findAll();
        return users;
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable long id) {
        User user = userRepo.getById(id);
        return user;
    }

    @PutMapping("/updateUserById/{id}")
    public User updateUser(@PathVariable long id, @RequestBody User user) {
        user.setId(id);
        User newUser = userRepo.saveAndFlush(user);
        return newUser;
    }

    @DeleteMapping("/deleteUserById/{id}")
    public void deleteUserById(@PathVariable long id) {
        userRepo.deleteById(id);
    }

    @DeleteMapping("")
    public void deleteUsers(@RequestParam List<Long> ids) {
        userRepo.deleteAllById(ids);
    }

}
