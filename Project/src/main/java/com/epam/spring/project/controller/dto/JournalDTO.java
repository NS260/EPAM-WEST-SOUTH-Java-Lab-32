package com.epam.spring.project.controller.dto;

import com.epam.spring.project.service.model.course.Course;
import com.epam.spring.project.service.model.user.Student;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JournalDTO {
    private int mark;
    private Course course;
    private Student student;
}
