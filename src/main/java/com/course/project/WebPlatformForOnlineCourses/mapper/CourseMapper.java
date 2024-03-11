package com.course.project.WebPlatformForOnlineCourses.mapper;

import com.course.project.WebPlatformForOnlineCourses.dao.category.CategoryDao;
import com.course.project.WebPlatformForOnlineCourses.model.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class CourseMapper implements RowMapper<Course> {

    private final CategoryDao categoryDao;

    @Override
    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
        return rs.wasNull() ? null : Course.builder()
                .id(rs.getLong("course_id"))
                .name(rs.getString("name"))
                .description(rs.getString("description"))
                .startDate(rs.getDate("start_date").toLocalDate())
                .durationInMonths(rs.getInt("duration_in_months"))
                .numberOfLessons(rs.getInt("number_of_lessons"))
                .categories(categoryDao.getCategoriesListForCourse(rs.getLong("category_id")))
                .build();
    }

    public Map<String, Object> toMap(Course course) {
        Map<String, Object> values = new HashMap<>();
        values.put("name", course.getName());
        values.put("description", course.getDescription());
        values.put("start_date", course.getStartDate());
        values.put("duration_in_months", course.getDurationInMonths());
        values.put("number_of_lessons", course.getNumberOfLessons());
        return values;
    }
}
