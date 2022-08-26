package com.epam.spring.project.service.model.journal;

import com.epam.spring.project.service.model.course.Course;
import com.epam.spring.project.service.model.user.Student;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Journal {
    private Integer mark;
    private Course course;
    private Student student;
}
