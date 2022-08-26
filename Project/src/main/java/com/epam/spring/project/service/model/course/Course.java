package com.epam.spring.project.service.model.course;

import com.epam.spring.project.service.model.course.constant.Direction;
import com.epam.spring.project.service.model.course.constant.Status;
import com.epam.spring.project.service.model.user.Teacher;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Course {
    private Long id;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Direction direction;
    private Status status;
    private Teacher teacher;
    private Integer numberOfStudents;
}
