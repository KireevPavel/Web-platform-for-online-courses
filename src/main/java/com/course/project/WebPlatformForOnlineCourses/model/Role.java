package com.course.project.WebPlatformForOnlineCourses.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class Role {
    private Long id;
    private String name;
}
