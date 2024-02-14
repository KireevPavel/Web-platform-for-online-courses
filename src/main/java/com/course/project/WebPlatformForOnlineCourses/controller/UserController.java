package com.course.project.WebPlatformForOnlineCourses.controller;

import com.course.project.WebPlatformForOnlineCourses.model.User;
import com.course.project.WebPlatformForOnlineCourses.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public User create(@Valid @RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping
    public User updateUser(@Valid @RequestBody User user) {
        return userService.updateUser(user);
    }

    @GetMapping
    public Collection<User> getUsers() {
        return userService.getAllUsers().values();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public User removeUserById(@PathVariable long id) {
        return userService.removeUserById(id);
    }
}
