package com.course.project.WebPlatformForOnlineCourses.model;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Transient;


import java.time.LocalDate;
import java.util.Set;

@Builder
@Data
public class User {
    private long id;
    @NonNull
    private String name;
    @Email
    @NonNull
    private String email;
    @NonNull
    @NotBlank
    private String login;
    @Size(min = 5, message = "Не меньше 5 знаков")
    private String password;
    @Transient
    private String PasswordConfirm;
    @Past
    private LocalDate birthday;
    @AssertFalse
    private boolean loggedIn;
    private Set<Role> roles;

}


