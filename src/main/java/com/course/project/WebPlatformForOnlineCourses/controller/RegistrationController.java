package com.course.project.WebPlatformForOnlineCourses.controller;


import com.course.project.WebPlatformForOnlineCourses.model.User;
import com.course.project.WebPlatformForOnlineCourses.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/registration")
public class RegistrationController {


    private final UserService userService;

    @GetMapping
    public String registration(Model model) {
        model.addAttribute("userForm", User.builder());

        return "registration";
    }

    @PostMapping
    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }
        if (!userService.addUser(userForm)) {
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }

        return "redirect:/";
    }
}