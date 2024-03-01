package com.course.project.WebPlatformForOnlineCourses.dao.course;

import com.course.project.WebPlatformForOnlineCourses.model.Course;

import java.util.List;

public interface CourseDao {
    List<Course> getAll();

    Course add(Course course);

    Course update(Course course);

    Course getById(long id);

    void removeById(long id);
}
