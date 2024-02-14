package com.course.project.WebPlatformForOnlineCourses.service.user;

import com.course.project.WebPlatformForOnlineCourses.model.User;
import com.course.project.WebPlatformForOnlineCourses.storage.user.UserStorage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserStorage userStorage;

    private void userValidation(User user) {
        if (user.getName() == null || user.getName().isBlank()) {
            user.setName(user.getLogin());
        }
    }

    @Override
    public HashMap<Long, User> getAllUsers() {
        return userStorage.get();
    }

    @Override
    public User addUser(User user) {
        userValidation(user);
        return userStorage.add(user);
    }

    @Override
    public User updateUser(User user) {
        userValidation(user);
        return userStorage.update(user);
    }

    @Override
    public User getUserById(long id) {
        return userStorage.getById(id);
    }

    @Override
    public User removeUserById(long id) {
        return userStorage.removeById(id);
    }

}
