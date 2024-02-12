package com.course.project.WebPlatformForOnlineCourses.storage;

import com.course.project.WebPlatformForOnlineCourses.model.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
@Slf4j
@Component
public class InMemoryCourseStorage implements Storage<Course> {

    private final HashMap<Long, Course> courses = new HashMap<>();
    private long id = 0;

    private long generateId() {
        return ++id;
    }

    @Override
    public HashMap<Long, Course> get() {
        return courses;
    }

    @Override
    public Course add(Course course) {
        course.setId(generateId());
        courses.put(course.getId(), course);
        return course;
    }

    @Override
    public Course update(Course course) {
        courses.put(course.getId(), course);
        return course;
    }

    @Override
    public Course getById(long id) {
        return courses.get(id);
    }

    @Override
    public Course removeById(long id) {
        return courses.remove(id);
    }
}
