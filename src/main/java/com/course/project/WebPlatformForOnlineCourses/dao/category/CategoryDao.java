package com.course.project.WebPlatformForOnlineCourses.dao.category;

import com.course.project.WebPlatformForOnlineCourses.model.Category;

import java.util.List;

public interface CategoryDao {

    Category get(long id);

    List<Category> getAll();

    List<Category> getCategoriesListForCourse(long courseId);

    List<Category> add(long courseId, List<Category> categories);

    void delete(long courseId);

}
