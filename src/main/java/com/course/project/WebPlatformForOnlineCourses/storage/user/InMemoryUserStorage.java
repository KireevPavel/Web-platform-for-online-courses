package com.course.project.WebPlatformForOnlineCourses.storage.user;


import com.course.project.WebPlatformForOnlineCourses.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Slf4j
@Component
public class InMemoryUserStorage implements UserStorage {
    private final HashMap<Long, User> users = new HashMap<>();
    private long id = 0;

    private long generateId() {
        return ++id;
    }

    @Override
    public HashMap<Long, User> get() {
        return users;
    }

    @Override
    public User add(User user) {
        user.setId(generateId());
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User update(User user) {
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User getById(long id) {
        return users.get(id);
    }

    @Override
    public User removeById(long id) {
        return users.remove(id);
    }
}
