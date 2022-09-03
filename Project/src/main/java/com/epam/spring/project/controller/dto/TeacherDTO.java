package com.epam.spring.project.controller.dto;

import com.epam.spring.project.controller.validation.ValidPassword;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeacherDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Positive(message = "{id.positive}")
    private Long id;
    @NotEmpty(message = "{teacher.name.nonempty}")
    @Size(min = 2, max = 30,message = "{teacher.name.size}")
    private String firstName;
    @NotEmpty(message = "{teacher.name.nonempty}")
    @Size(min = 2, max = 30, message = "{teacher.name.size}")
    private String lastName;
    @NotEmpty(message = "{nickname.nonempty}")
    @Size(min = 5, max = 30,message = "{teacher.nickname.size}")
    private String nickName;
    @Email(message = "{email.source}")
    private String email;
    @NotEmpty(message = "{password.nonempty}")
    @ValidPassword(message = "{password.valid}")
    private String password;
}
