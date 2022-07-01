package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.beans.interfaces.Beannable;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class BeanF implements Beannable {
    private String name;
    private Integer value;
}
