package com.epam.spring.project.service.model.course.constant;


import lombok.Getter;
import lombok.Setter;

public enum Direction {
    NONE(0),
    DEVELOPMENT(1),
    BUSINESS(2),
    FINANCE_ACCOUNTING(3),
    IT_SOFTWARE(4),
    OFFICE_PRODUCTIVITY(5),
    PERSONAL_DEVELOPMENT(6),
    DESIGN(7);

    @Setter
    @Getter
    private int key;

    Direction(int key) {
        this.key = key;
    }
}
