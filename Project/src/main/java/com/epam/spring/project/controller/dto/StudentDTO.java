package com.epam.spring.project.controller.dto;

import com.epam.spring.project.controller.validation.ValidPassword;
import com.epam.spring.project.service.model.user.constant.Block;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class StudentDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Positive
    private Long id;
    @NotEmpty
    @Size(min = 2, max = 30)
    private String firstName;
    @NotEmpty
    @Size(min = 2, max = 30)
    private String lastName;
    @NotEmpty
    @Size(min = 5, max = 30)
    private String nickName;
    @Email
    private String email;
    @NotEmpty
    @ValidPassword
    private String password;
    @NotNull
    private Block block;
    @NotEmpty
    private final List<CourseDTO> courseDto = new ArrayList<>();
}
