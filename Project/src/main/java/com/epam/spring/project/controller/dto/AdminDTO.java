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
    @NotNull(message = "{id.notnull}")
    @Positive(message = "{id.positive}")
    private Long id;
    @NotEmpty(message = "{nickname.nonempty}")
    @Size(min = 5, max = 20,message = "{nickname.size}")
    private String nickName;
    @Email(message = "{email.source}")
    private String email;
    @NotEmpty(message = "{password.nonempty}")
    @ValidPassword(message = "{password.valid}")
    private String password;
}
