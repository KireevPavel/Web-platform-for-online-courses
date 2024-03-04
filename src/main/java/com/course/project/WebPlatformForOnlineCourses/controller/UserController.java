package com.course.project.WebPlatformForOnlineCourses.controller;

import com.course.project.WebPlatformForOnlineCourses.model.User;
import com.course.project.WebPlatformForOnlineCourses.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/Users")
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
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        log.info("GET запрос на получение списка друзей пользователя с id: {}", id);
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void removeUserById(@PathVariable long id) {
        userService.removeUserById(id);
    }
}
