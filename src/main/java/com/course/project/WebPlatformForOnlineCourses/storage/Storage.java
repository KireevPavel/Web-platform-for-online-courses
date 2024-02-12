package com.course.project.WebPlatformForOnlineCourses.storage;

import java.util.HashMap;

public interface Storage<T> {

    HashMap<Long, T> get();

    T add(T value);

    T update(T value);

    T getById(long id);

    T removeById(long id);
}
