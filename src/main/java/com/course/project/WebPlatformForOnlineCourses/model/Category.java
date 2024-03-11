package com.course.project.WebPlatformForOnlineCourses.model;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Category {
    @NotNull
    private long id;
    @NotNull
    private String name;
}
