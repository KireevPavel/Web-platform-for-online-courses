package com.course.project.WebPlatformForOnlineCourses.service.user;

import com.course.project.WebPlatformForOnlineCourses.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    boolean addUser(User user);

    User updateUser(User user);

    User getUserById(long id);

    void removeUserById(long id);

}
