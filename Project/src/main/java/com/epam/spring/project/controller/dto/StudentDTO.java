package com.epam.spring.project.controller.dto;

import com.epam.spring.project.service.model.user.constant.Block;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class StudentDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    private String firstName;
    private String lastName;
    private String nickName;
    private String email;
    private String password;
    private Block block;
    private final List<CourseDTO> courseDto = new ArrayList<>();
}
