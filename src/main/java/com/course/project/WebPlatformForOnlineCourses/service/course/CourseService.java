package com.course.project.WebPlatformForOnlineCourses.service.course;

import com.course.project.WebPlatformForOnlineCourses.model.Course;

import java.util.HashMap;

public interface CourseService {

    HashMap<Long, Course> getAllCourses();

    Course addCourse(Course course);

    Course updateCourse(Course course);

    Course getCourseById(long id);

    Course removeCourseById(long id);
}
