package com.course.project.WebPlatformForOnlineCourses.mapper;

import com.course.project.WebPlatformForOnlineCourses.model.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return rs.wasNull() ? null : User.builder()
                .id(rs.getLong("user_id"))
                .name(rs.getString("name"))
                .email(rs.getString("email"))
                .login(rs.getString("login"))
                .password(rs.getString("password"))
                .birthday(rs.getDate("birthday").toLocalDate())
                .loggedIn(rs.getBoolean("logged_in"))
                .status(rs.getString("status"))
                .build();
    }

    public Map<String, Object> toMap(User user) {
        Map<String, Object> values = new HashMap<>();
        values.put("name", user.getName());
        values.put("email", user.getEmail());
        values.put("login", user.getLogin());
        values.put("password", user.getPassword());
        values.put("birthday", user.getBirthday());
        values.put("logged_in", user.isLoggedIn());
        values.put("status", user.getStatus());
        return values;
    }

}
