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
    @Positive(message = "{id.positive}")
    private Long id;
    @NotEmpty(message = "{name.nonempty}")
    @Size(min = 2, max = 30,message = "{student.size}")
    private String firstName;
    @NotEmpty(message = "{name.nonempty}")
    @Size(min = 2, max = 30,message = "{student.size}")
    private String lastName;
    @NotEmpty(message = "{nickname.nonempty}")
    @Size(min = 5, max = 30,message = "{nickname.size}")
    private String nickName;
    @Email(message = "{email.source}")
    private String email;
    @NotEmpty(message = "{password.nonempty}")
    @ValidPassword(message = "{password.valid}")
    private String password;
    @NotNull(message = "{block.notnull}")
    private Block block;
    @NotEmpty(message = "{student.courses.nonempty}")
    private final List<CourseDTO> courseDto = new ArrayList<>();
}
