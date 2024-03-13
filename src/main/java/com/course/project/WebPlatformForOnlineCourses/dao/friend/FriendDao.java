package com.course.project.WebPlatformForOnlineCourses.dao.friend;

import com.course.project.WebPlatformForOnlineCourses.model.User;

import java.util.List;

public interface FriendDao {

    List<User> get(long userId);

    void add(long firstUserId, long secondUserId);

    void removeById(long firstUserId, long secondUserId);

    List<User> getMutualFriends(long firstUserId, long secondUserId);
}
