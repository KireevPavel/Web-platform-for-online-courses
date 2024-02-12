package com.course.project.WebPlatformForOnlineCourses.service.user;

import com.course.project.WebPlatformForOnlineCourses.model.User;

import java.util.HashMap;
import java.util.List;

public interface UserService {
    HashMap<Long, User> getAllUsers();

    User addUser(User user);

    User updateUser(User user);

    User getUserById(long id);

    User removeUserById(long id);

    List<User> getFriendsByUserId(long id);

    List<User> getMutualFriends(long userId, long friendId);

    User addFriend(long userId, long friendId);

    User deleteFriend(long userId, long friendId);
}
