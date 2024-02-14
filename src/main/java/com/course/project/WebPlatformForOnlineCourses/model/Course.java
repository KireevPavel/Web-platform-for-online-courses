package com.course.project.WebPlatformForOnlineCourses.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
public class Course {
    private long id;
    @NotBlank
    @NonNull
    private String name;
    @Size(max = 200)
    private String description;
    @Past
    private LocalDate startDate;
    @Positive
    private int durationInMonths;
    @Positive
    private int numberOfLessons;
    @NonNull
    private Set<Long> likes;
    @NonNull
    private Set<Category> category;


}
