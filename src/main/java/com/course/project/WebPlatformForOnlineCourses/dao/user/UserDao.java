package com.course.project.WebPlatformForOnlineCourses.dao.user;

import com.course.project.WebPlatformForOnlineCourses.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAll();

    User add(User user);

    User update(User user);

    User getById(long id);

    void removeById(long id);

    User findByUsername(String username);
}
