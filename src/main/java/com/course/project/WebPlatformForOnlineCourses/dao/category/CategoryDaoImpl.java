package com.course.project.WebPlatformForOnlineCourses.dao.category;

import com.course.project.WebPlatformForOnlineCourses.exception.ObjectNotFoundException;
import com.course.project.WebPlatformForOnlineCourses.mapper.CategoryMapper;
import com.course.project.WebPlatformForOnlineCourses.model.Category;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Repository
public class CategoryDaoImpl implements CategoryDao {

    private final JdbcTemplate jdbcTemplate;
    private final CategoryMapper categoryMapper;

    @Override
    public Category get(long id) {
        try {
            String sql = "SELECT * FROM categories WHERE category_id = ?";


            return jdbcTemplate.queryForObject(sql, categoryMapper, id);
        } catch (RuntimeException e) {
            log.info("Категории с id - {} не существует", id);
            throw new ObjectNotFoundException("Категория не найдена");
        }
    }

    @Override
    public List<Category> getAll() {
        try {
            String sql = "SELECT * FROM categories";
            return jdbcTemplate.query(sql, categoryMapper);
        } catch (RuntimeException e) {
            log.info("Список категорий пуст");
            throw new ObjectNotFoundException("Список категорий пуст");
        }
    }

    @Override
    public List<Category> getCategoriesListForCourse(long courseId) {
        String sql = "SELECT cc.*, c.name FROM course_categories AS cc JOIN categories AS c ON " +
                "c.course_id = cc.course_id WHERE cc.course_id = ?";
        return jdbcTemplate.query(sql, categoryMapper, courseId);
    }

    @Override
    public List<Category> add(long courseId, List<Category> categories) {
        String sql = "MERGE INTO course_categories (course_id, category_id) KEY(course_id, category_id) VALUES (?, ?)";
        if (categories == null || categories.isEmpty()) {
            log.info("Категория ещё не была добавлена в базу.");
            return new ArrayList<>();
        }
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setLong(1, courseId);
                ps.setLong(2, categories.get(i).getId());
            }

            @Override
            public int getBatchSize() {
                return categories.size();
            }
        });
        return getCategoriesListForCourse(courseId);
    }

    @Override
    public void delete(long courseId) {
        String sql = "DELETE FROM course_categories WHERE course_id = ?";
        jdbcTemplate.update(sql, courseId);
    }
}
