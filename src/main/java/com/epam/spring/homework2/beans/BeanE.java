package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.beans.interfaces.Beannable;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
@Component
public class BeanE implements Beannable {
    private String name;
    private Integer value;
    @PostConstruct
    public void postConstruct(){
        System.out.println("[INIT] PostConstruct method defined as :construct(): was loaded for bean: BeanE");
    }
    @PreDestroy
    public void preDestroy(){
        System.out.println("[DESTROY] PreDestroy method defined as :destroy(): was loaded for bean: BeanE");
    }
}