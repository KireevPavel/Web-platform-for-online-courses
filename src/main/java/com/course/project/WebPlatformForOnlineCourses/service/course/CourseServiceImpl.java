package com.course.project.WebPlatformForOnlineCourses.service.course;

import com.course.project.WebPlatformForOnlineCourses.dao.course.CourseDao;
import com.course.project.WebPlatformForOnlineCourses.model.Course;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {

    private final CourseDao courseDao;

    @Override
    public List<Course> getAllCourses() {
        return courseDao.getAll();
    }

    @Override
    public Course addCourse(Course course) {
        courseDao.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        return courseDao.update(course);
    }

    @Override
    public Course getCourseById(long id) {
        return courseDao.getById(id);
    }

    @Override
    public void removeCourseById(long id) {
        courseDao.removeById(id);
    }

}
