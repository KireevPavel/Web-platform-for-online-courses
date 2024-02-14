package com.course.project.WebPlatformForOnlineCourses.service.course;

import com.course.project.WebPlatformForOnlineCourses.model.Course;
import com.course.project.WebPlatformForOnlineCourses.storage.course.CourseStorage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {

    private final CourseStorage courseStorage;

    @Override
    public HashMap<Long, Course> getAllCourses() {
        return courseStorage.get();
    }

    @Override
    public Course addCourse(Course course) {
        courseStorage.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        return courseStorage.update(course);
    }

    @Override
    public Course getCourseById(long id) {
        return courseStorage.getById(id);
    }

    @Override
    public Course removeCourseById(long id) {
        return courseStorage.removeById(id);
    }

}
