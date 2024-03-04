package com.course.project.WebPlatformForOnlineCourses.service.friend;

import com.course.project.WebPlatformForOnlineCourses.dao.friends.FriendDao;
import com.course.project.WebPlatformForOnlineCourses.dao.user.UserDao;
import com.course.project.WebPlatformForOnlineCourses.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FriendServiceImpl implements FriendService {
    private final FriendDao friendDao;

    @Override
    public List<User> getFriends(long userId) {
        return friendDao.get(userId);
    }

    @Override
    public void addFriend(long firstUserId, long secondUserId) {
        friendDao.add(firstUserId, secondUserId);
    }

    @Override
    public void removeFriendById(long firstUserId, long secondUserId) {
        friendDao.removeById(firstUserId, secondUserId);
    }

    @Override
    public List<User> getMutualFriends(long firstUserId, long secondUserId) {
        return friendDao.getMutualFriends(firstUserId, secondUserId);
    }
}
