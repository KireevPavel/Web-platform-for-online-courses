package com.course.project.WebPlatformForOnlineCourses.dao.course;

import com.course.project.WebPlatformForOnlineCourses.exception.ObjectNotFoundException;
import com.course.project.WebPlatformForOnlineCourses.mapper.CourseMapper;
import com.course.project.WebPlatformForOnlineCourses.model.Course;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CourseDaoImpl implements CourseDao {

    private final JdbcTemplate jdbcTemplate;
    private final CourseMapper courseMapper;

    @Override
    public List<Course> getAll() {
        String sql = "SELECT * FROM courses";
        return jdbcTemplate.query(sql, courseMapper);
    }

    @Override
    public Course add(Course course) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("courses").usingGeneratedKeyColumns("course_id");
        course.setId(simpleJdbcInsert.executeAndReturnKey(courseMapper.toMap(course)).longValue());
        return course;
    }

    @Override
    public Course update(Course course) {
        String sql = "UPDATE courses SET name = ?, description = ?, start_date = ?, duration_in_months = ?," + "number_of_lessons = ? WHERE course_id = ?";
        jdbcTemplate.update(sql, course.getName(), course.getDescription(), course.getStartDate(), course.getDurationInMonths(), course.getNumberOfLessons(), course.getId());
        return course;
    }

    @Override
    public Course getById(long id) {
        try {
            String sql = "SELECT * FROM courses WHERE course_id = ?";
            return jdbcTemplate.queryForObject(sql, courseMapper, id);
        } catch (RuntimeException e) {
            log.info("Некорректный id {}", id);
            throw new ObjectNotFoundException("Курс не найден");
        }
    }

    @Override
    public void removeById(long id) {
        String sql = "DELETE FROM courses WHERE course_id = ?";
        jdbcTemplate.update(sql, id);
    }
}
