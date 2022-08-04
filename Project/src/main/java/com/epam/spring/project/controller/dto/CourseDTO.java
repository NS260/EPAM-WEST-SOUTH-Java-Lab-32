package com.epam.spring.project.controller.dto;

import com.epam.spring.project.service.model.course.constant.Direction;
import com.epam.spring.project.service.model.course.constant.Status;
import com.epam.spring.project.service.model.user.Teacher;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CourseDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Positive
    private Long id;
    @NotEmpty
    @Size(min = 10, max = 30)
    private String name;
    @PastOrPresent
    private LocalDateTime startDate;
    @FutureOrPresent
    private LocalDateTime endDate;
    @NotNull
    private Direction direction;
    @NotNull
    private Status status;
    @NotNull
    private Teacher teacher;
    @Positive
    private int numberOfStudents;
}
