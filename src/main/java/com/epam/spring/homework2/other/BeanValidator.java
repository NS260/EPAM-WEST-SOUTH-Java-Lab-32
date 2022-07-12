package com.epam.spring.homework2.other;

import com.epam.spring.homework2.beans.interfaces.Beannable;
import com.epam.spring.homework2.other.validate.Validator;
import com.epam.spring.homework2.other.validate.ValidatorImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanValidator implements BeanPostProcessor {
    private final Validator validator = new ValidatorImpl();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[BEFORE INIT] Method postProcessBeforeInitialization was executed on bean: " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[AFTER INIT] Method postProcessAfterInitialization was executed on bean: " + beanName);
        if (bean instanceof Beannable) {
            this.validator.validate((Beannable) bean);
        }
        return bean;
    }
}
