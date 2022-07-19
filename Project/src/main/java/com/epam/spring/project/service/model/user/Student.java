package com.epam.spring.project.service.model.user;

import com.epam.spring.project.service.model.course.Course;
import com.epam.spring.project.service.model.user.constant.Block;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private String nickName;
    private String email;
    private String password;
    private Block block;
    private List<Course> courseList;
    private LocalDateTime createDate;
}
