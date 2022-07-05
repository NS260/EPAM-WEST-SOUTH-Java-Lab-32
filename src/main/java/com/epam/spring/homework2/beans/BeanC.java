package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.beans.interfaces.Beannable;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class BeanC implements Beannable {
    @Value("${beanC.name}")
    private String name;
    @Value("${beanC.value}")
    private Integer value;

    public void init() {
        System.out.println("[INIT] User method :init(): was loaded on BeanC");
    }

    public void destroy() {
        System.out.println("[DESTROY] User method :destroy(): was loaded on BeanC");
    }
}
