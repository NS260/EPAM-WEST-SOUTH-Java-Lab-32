package com.epam.spring.project.controller.dto;

import com.epam.spring.project.controller.validation.ValidPassword;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @NotNull
    @Positive
    private Long id;
    @NotEmpty
    @Size(min = 5, max = 20)
    private String nickName;
    @Email
    private String email;
    @NotEmpty
    @ValidPassword
    private String password;
}
