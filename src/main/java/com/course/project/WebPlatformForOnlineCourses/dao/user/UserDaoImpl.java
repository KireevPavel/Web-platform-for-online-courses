package com.course.project.WebPlatformForOnlineCourses.dao.user;


import com.course.project.WebPlatformForOnlineCourses.exception.ObjectNotFoundException;
import com.course.project.WebPlatformForOnlineCourses.mapper.UserMapper;
import com.course.project.WebPlatformForOnlineCourses.model.Role;
import com.course.project.WebPlatformForOnlineCourses.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;
    private final UserMapper userMapper;


    @Override
    public List<User> getAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, userMapper);

    }

    @Override
    public User add(User user) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("Users")
                .usingGeneratedKeyColumns("user_id");
        user.setId(simpleJdbcInsert.executeAndReturnKey(userMapper.toMap(user)).longValue());
        user.setRoles(Collections.singleton(Role.builder()
                .id(1L)
                .name("ROLE_USER")
                .build()));


        return user;
    }

    @Override
    public User update(User user) {
        String sql = "UPDATE users SET name = ?, email = ?, login = ?, password = ?, birthday = ?, logged_in = ?, " +
                "status = ? WHERE user_id = ?";

        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getLogin(), user.getPassword(),
                user.getBirthday(), user.isLoggedIn(), user.getId());
        return user;
    }

    @Override
    public User getById(long id) {
        try {
            String sql = "SELECT * FROM Users WHERE user_id = ?";
            return jdbcTemplate.queryForObject(sql, userMapper, id);
        } catch (RuntimeException e) {
            log.info("Некорректный id {}", id);
            throw new ObjectNotFoundException("Пользователь не найден");
        }

    }

    @Override
    public void removeById(long id) {
        String sql = "DELETE FROM Users WHERE user_id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public User findByUsername(String username) {
        try {
            String sql = "SELECT * FROM Users WHERE login = ?";
            return jdbcTemplate.queryForObject(sql, userMapper, username);
        } catch (RuntimeException e) {
            log.info("Некорректный login {}", username);
            throw new ObjectNotFoundException("Пользователь не найден");
        }

    }
}
