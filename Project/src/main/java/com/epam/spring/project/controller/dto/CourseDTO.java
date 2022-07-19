package com.epam.spring.project.controller.dto;

import com.epam.spring.project.service.model.course.constant.Direction;
import com.epam.spring.project.service.model.course.constant.Status;
import com.epam.spring.project.service.model.user.Teacher;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CourseDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Direction direction;
    private Status status;
    private Teacher teacher;
    private int numberOfStudents;
}
