package com.course.project.WebPlatformForOnlineCourses.service.user;

import com.course.project.WebPlatformForOnlineCourses.model.User;

import java.util.HashMap;

public interface UserService {
    HashMap<Long, User> getAllUsers();

    User addUser(User user);

    User updateUser(User user);

    User getUserById(long id);

    User removeUserById(long id);

}
