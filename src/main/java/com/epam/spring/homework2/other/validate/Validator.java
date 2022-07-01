package com.epam.spring.homework2.other.validate;

import com.epam.spring.homework2.beans.interfaces.Beannable;

public interface Validator {
    void validate(Beannable bean);
}
