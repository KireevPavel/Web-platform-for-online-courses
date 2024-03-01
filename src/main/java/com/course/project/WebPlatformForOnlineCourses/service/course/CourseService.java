package com.course.project.WebPlatformForOnlineCourses.service.course;

import com.course.project.WebPlatformForOnlineCourses.model.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

    Course addCourse(Course course);

    Course updateCourse(Course course);

    Course getCourseById(long id);

    void removeCourseById(long id);
}
