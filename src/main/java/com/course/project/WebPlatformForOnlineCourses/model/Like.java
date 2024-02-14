package com.course.project.WebPlatformForOnlineCourses.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class Like {
    @NotNull
    private long id;
    @NotNull
    @Positive
    private long userId;
    @NotNull
    @Positive
    private long filmId;
}
