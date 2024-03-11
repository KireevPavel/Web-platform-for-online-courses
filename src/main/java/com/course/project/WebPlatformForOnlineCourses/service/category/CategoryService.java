package com.course.project.WebPlatformForOnlineCourses.service.category;

import com.course.project.WebPlatformForOnlineCourses.model.Category;

import java.util.List;

public interface CategoryService {

    Category getCategory(long id);

    List<Category> getAllCategories();
}
