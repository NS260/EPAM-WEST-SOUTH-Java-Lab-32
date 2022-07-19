package com.epam.spring.project.service.model.user;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Admin {
    private Long id;
    private String nickName;
    private String email;
    private String password;
    private LocalDateTime createDate;
}
