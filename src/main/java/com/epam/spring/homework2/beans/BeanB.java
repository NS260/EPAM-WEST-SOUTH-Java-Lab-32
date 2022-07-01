package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.beans.interfaces.Beannable;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class BeanB implements Beannable {
    @Value("${beanB.name}")
    private String name;
    @Value("${beanB.value}")
    private Integer value;

    public void init() {
        System.out.println("[INIT] User method :init(): was loaded on BeanB");
    }

    public void destroy() {
        System.out.println("[DESTROY] User method :destroy(): was loaded on BeanB");
    }

    public void modify() {
        System.out.println("[INIT] User method :modify(): was loaded on BeanB");
    }
}
