package com.epam.spring.project.service.model.user;

import com.epam.spring.project.service.model.course.Course;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class Teacher {
    private Long id;
    private String firstName;
    private String lastName;
    private String nickName;
    private String email;
    private String password;
    private List<Course> courseList;
    private LocalDateTime createDate;
}
