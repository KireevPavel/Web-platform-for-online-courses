package com.course.project.WebPlatformForOnlineCourses.orm;

import com.course.project.WebPlatformForOnlineCourses.model.Course;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Component
public class CourseOrm implements RowMapper<Course> {

    @Override
    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
        return rs.wasNull() ? null : Course.builder()
                .id(rs.getLong("course_id"))
                .name(rs.getString("name"))
                .description(rs.getString("description"))
                .startDate(rs.getDate("start_date").toLocalDate())
                .durationInMonths(rs.getInt("duration_in_months"))
                .numberOfLessons(rs.getInt("number_of_lessons"))
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
