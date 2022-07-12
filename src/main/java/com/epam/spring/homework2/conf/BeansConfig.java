package com.epam.spring.homework2.conf;

import com.epam.spring.homework2.beans.BeanA;
import com.epam.spring.homework2.beans.BeanE;
import com.epam.spring.homework2.beans.BeanF;
import com.epam.spring.homework2.other.BeanChanger;
import com.epam.spring.homework2.other.BeanValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

@Import(ResourcesConfig.class)
@Configuration
public class BeansConfig {
    @Lazy
    @Bean
    BeanF beanF() {
        return new BeanF();
    }

    @Bean
    BeanA beanA() {
        return new BeanA();
    }

    @Bean
    BeanE beanE() {
        return new BeanE();
    }

    @Bean
    BeanChanger beanChanger() {
        return new BeanChanger();
    }

    @Bean
    BeanValidator beanValidator() {
        return new BeanValidator();
    }
}
