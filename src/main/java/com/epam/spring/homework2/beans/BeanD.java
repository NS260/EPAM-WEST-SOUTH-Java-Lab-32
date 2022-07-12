package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.beans.interfaces.Beannable;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class BeanD implements Beannable {
    @Value("${beanD.name}")
    private String name;
    @Value("${beanD.value}")
    private Integer value;

    public void init() {
        System.out.println("[INIT] User method :init(): was loaded on BeanD");
    }

    public void destroy() {
        System.out.println("[DESTROY] User method :destroy(): was loaded on BeanD");
    }
}
