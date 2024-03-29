package com.epam.spring.homework2;

import com.epam.spring.homework2.conf.BeansConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ap = new AnnotationConfigApplicationContext(BeansConfig.class);
        Arrays.stream(ap.getBeanDefinitionNames()).forEach(System.out::println);
        ap.close();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println("[CONFIGURATION] " + name + " : " + context.getBeanDefinition(name));
        }
        context.close();
    }
}
