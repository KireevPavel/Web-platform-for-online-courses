package com.course.project.WebPlatformForOnlineCourses.storage.course;

import com.course.project.WebPlatformForOnlineCourses.model.Course;

import java.util.HashMap;

public interface CourseStorage {
    HashMap<Long, Course> get();

    Course add(Course course);

    Course update(Course course);

    Course getById(long id);

    Course removeById(long id);
}
