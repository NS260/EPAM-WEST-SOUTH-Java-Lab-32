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
    @Positive(message = "{id.positive}")
    private Long id;
    @NotEmpty(message = "{name.nonempty}")
    @Size(min = 10, max = 30,message = "{name.size}")
    private String name;
    @PastOrPresent(message = "{date.start}")
    private LocalDateTime startDate;
    @FutureOrPresent(message = "{date.end}")
    private LocalDateTime endDate;
    @NotNull(message = "{direction.notnull}")
    private Direction direction;
    @NotNull(message = "{status.notnull}")
    private Status status;
    @NotNull(message = "{teacher.notnull}")
    private Teacher teacher;
    @Positive(message = "{number.positive}")
    private int numberOfStudents;
}
