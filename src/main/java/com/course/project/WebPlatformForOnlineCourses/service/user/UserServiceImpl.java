package com.course.project.WebPlatformForOnlineCourses.service.user;

import com.course.project.WebPlatformForOnlineCourses.dao.user.UserDao;
import com.course.project.WebPlatformForOnlineCourses.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    private void userValidation(User user) {
        if (user.getName().isBlank()) {
            user.setName(user.getLogin());
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    @Override
    public User addUser(User user) {
        userValidation(user);
        return userDao.add(user);
    }

    @Override
    public User updateUser(User user) {
        userValidation(user);
        return userDao.update(user);
    }

    @Override
    public User getUserById(long id) {
        return userDao.getById(id);
    }

    @Override
    public void removeUserById(long id) {
        userDao.removeById(id);
    }

}
