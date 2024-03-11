package com.course.project.WebPlatformForOnlineCourses.service.category;

import com.course.project.WebPlatformForOnlineCourses.dao.category.CategoryDao;
import com.course.project.WebPlatformForOnlineCourses.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {


    private final CategoryDao categoryDao;

    @Override
    public Category getCategory(long id) {
        return categoryDao.get(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.getAll();
    }
}
