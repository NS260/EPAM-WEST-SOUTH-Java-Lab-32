package com.epam.spring.homework2.other.validate;

import com.epam.spring.homework2.beans.interfaces.Beannable;

public class ValidatorImpl implements Validator {
    @Override
    public void validate(Beannable bean) {
        if (bean.toString().matches(".*\\bnull\\b.*")) {
            System.out.println("[VALIDATE] Validation of " + bean.getClass().getSimpleName() + " wasn`t successful. [" + bean + "]");
        } else {
            System.out.println("[VALIDATE] Validation of " + bean.getClass().getSimpleName() + " was successful. [" + bean + "]");
        }
    }
}
