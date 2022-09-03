package com.epam.spring.project.controller.dto;

import com.epam.spring.project.service.model.course.Course;
import com.epam.spring.project.service.model.user.Student;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
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
