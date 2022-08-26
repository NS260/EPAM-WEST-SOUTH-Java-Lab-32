package com.epam.spring.project.controller.dto;

import com.epam.spring.project.service.model.course.Course;
import com.epam.spring.project.service.model.user.Student;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JournalDTO {
    @PositiveOrZero(message = "{mark.status}")
    private int mark;
    @NotNull(message = "{course.notnull}")
    private Course course;
    @NotNull(message = "{student.notnull}")
    private Student student;
}
