package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.beans.interfaces.Beannable;
import lombok.Data;

@Data
public class BeanF implements Beannable {
    private String name;
    private Integer value;
}
