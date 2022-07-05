package com.epam.spring.homework2.conf;

import com.epam.spring.homework2.beans.BeanB;
import com.epam.spring.homework2.beans.BeanC;
import com.epam.spring.homework2.beans.BeanD;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:resources.properties")
@Configuration
public class ResourcesConfig {
    @DependsOn({"beanD"})
    @Bean(
            initMethod = "init",
            destroyMethod = "destroy"
    )
    BeanB beanB() {
        return new BeanB();
    }

    @DependsOn({"beanB", "beanD"})
    @Bean(
            initMethod = "init",
            destroyMethod = "destroy"
    )
    BeanC beanC() {
        return new BeanC();
    }

    @Bean(
            initMethod = "init",
            destroyMethod = "destroy"
    )
    BeanD beanD() {
        return new BeanD();
    }
}
