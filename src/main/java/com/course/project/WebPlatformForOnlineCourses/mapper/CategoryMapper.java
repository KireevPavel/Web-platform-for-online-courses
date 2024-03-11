package com.course.project.WebPlatformForOnlineCourses.mapper;

import com.course.project.WebPlatformForOnlineCourses.model.Category;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CategoryMapper implements RowMapper<Category> {

    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        return rs.wasNull() ? null : Category.builder()
                .id(rs.getLong("category_id"))
                .name(rs.getString("name"))
                .build();
    }
}
