package com.course.project.WebPlatformForOnlineCourses.controller;

import com.course.project.WebPlatformForOnlineCourses.model.Course;
import com.course.project.WebPlatformForOnlineCourses.service.course.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public Course createCourse(@Valid @RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @PutMapping
    public Course updateCourse(@Valid @RequestBody Course course) {
        return courseService.updateCourse(course);
    }

    @GetMapping
    public Collection<Course> getCourses() {
        return courseService.getAllCourses().values();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable long id) {
        return courseService.getCourseById(id);
    }

    @DeleteMapping("/{id}")
    public Course removeCourseById(@PathVariable long id) {
        return courseService.removeCourseById(id);
    }
}
