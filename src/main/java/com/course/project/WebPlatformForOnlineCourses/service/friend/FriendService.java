package com.course.project.WebPlatformForOnlineCourses.service.friend;

import com.course.project.WebPlatformForOnlineCourses.model.User;

import java.util.List;

public interface FriendService {

    List<User> getFriends(long userId);
    void addFriend(long firstUserId, long secondUserId);

    void removeFriendById(long firstUserId, long secondUserId);

    List<User> getMutualFriends(long firstUserId, long secondUserId);
}
