package com.epam.spring.project.service.model.user.constant;

import lombok.Getter;
import lombok.Setter;

public enum Block {
    UNBLOCKED(0), BLOCKED(1);

    @Setter
    @Getter
    private int key;

    Block(int key) {
        this.key = key;
    }
}
