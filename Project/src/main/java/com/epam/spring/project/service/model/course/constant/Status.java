package com.epam.spring.project.service.model.course.constant;

import lombok.Getter;
import lombok.Setter;

public enum Status {
    NONE(0), PLANNED(1), CLOSED(2), OPEN(3);

    @Setter
    @Getter
    private int key;

    Status(int key) {
        this.key = key;
    }
}
