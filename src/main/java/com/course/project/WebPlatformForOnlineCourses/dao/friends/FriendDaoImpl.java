package com.course.project.WebPlatformForOnlineCourses.dao.friends;

import com.course.project.WebPlatformForOnlineCourses.model.User;
import com.course.project.WebPlatformForOnlineCourses.orm.UserOrm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class FriendDaoImpl implements FriendDao {

    private final JdbcTemplate jdbcTemplate;
    private final UserOrm userOrm;

    @Override
    public List<User> get(long userId) {
        String sql = "SELECT * FROM users WHERE user_id IN (SELECT friend_id FROM friends WHERE user_id = ?) ";
        return jdbcTemplate.query(sql, userOrm, userId);
    }

    @Override
    public void add(long firstUserId, long secondUserId) {
        String sql = "INSERT INTO friends(user_id, friend_id) VALUES (?,?)";
        jdbcTemplate.update(sql, firstUserId, secondUserId);
    }

    @Override
    public void removeById(long firstUserId, long secondUserId) {
        String sql = "DELETE FROM friends WHERE user_id = ? AND friend_id = ?";
        jdbcTemplate.update(sql, firstUserId, secondUserId);
    }

    @Override
    public List<User> getMutualFriends(long firstUserId, long secondUserId) {
        String sql = "SELECT u.user_id, email, login, name, birthday, status, password, logged_in\n" +
                "FROM friends as f1\n" +
                "JOIN friends as f2 ON  f2.friend_id = f1.friend_id AND f2.user_id = ?\n" +
                "JOIN users u on u.user_id = f1.friend_id\n" +
                "WHERE f1.user_id = ?";
        List<User> mutualFriend = jdbcTemplate.query(sql, userOrm, firstUserId, secondUserId);
        if (mutualFriend.isEmpty()) {
            log.info("У пользователей с id - {} и {} нет общих друзей", firstUserId, secondUserId);
            return Collections.emptyList();
        }
        return mutualFriend;
    }
}
