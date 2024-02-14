package com.course.project.WebPlatformForOnlineCourses.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Category {
    @NotNull
    private long id;
    @NotNull
    private String name;
}
