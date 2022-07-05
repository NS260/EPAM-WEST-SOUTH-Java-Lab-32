package com.epam.spring.homework1.config;

import com.epam.spring.homework1.pet.Cheetah;
import com.epam.spring.homework1.pet.Spider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@ComponentScan(basePackages = "com.epam.spring.homework1.pet", excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = Spider.class))
@Configuration
public class PetConfig {
    @Bean
    @Primary
    public Cheetah getCheetah() {
        return new Cheetah();
    }

    @Bean
    @Qualifier("cheetah1")
    public Cheetah getAnotherCheetah() {
        return new Cheetah();
    }

    @Bean
    public Cheetah getQualifierCheetah(@Qualifier("cheetah1") Cheetah cheetah) {
        return cheetah;
    }
}
