package com.course.project.WebPlatformForOnlineCourses.storage.user;

import com.course.project.WebPlatformForOnlineCourses.model.User;

import java.util.HashMap;

public interface UserStorage {

    HashMap<Long, User> get();

    User add(User user);

    User update(User user);

    User getById(long id);

    User removeById(long id);
}
