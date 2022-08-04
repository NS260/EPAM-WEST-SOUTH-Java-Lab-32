package com.epam.spring.project.controller.dto;

import com.epam.spring.project.controller.validation.ValidPassword;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeacherDTO {
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
}
