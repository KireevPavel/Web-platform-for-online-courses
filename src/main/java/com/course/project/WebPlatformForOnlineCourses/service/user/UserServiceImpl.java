package com.course.project.WebPlatformForOnlineCourses.service.user;

import com.course.project.WebPlatformForOnlineCourses.dao.user.UserDao;
import com.course.project.WebPlatformForOnlineCourses.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
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
    public boolean addUser(User user) {
        User userFromDB = userDao.findByUsername(user.getLogin());
        userValidation(user);
        return userFromDB == null;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        userValidation(user);
        return (UserDetails) user;
    }
}
