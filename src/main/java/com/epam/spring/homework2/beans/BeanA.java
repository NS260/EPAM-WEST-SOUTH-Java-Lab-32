package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.beans.interfaces.Beannable;
import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Data
public class BeanA implements Beannable, InitializingBean, DisposableBean {
    private String name;
    private Integer value;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("[INIT] Implemented method afterPropertiesSet() from interface Initializing Bean was loaded on the BeanA");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("[DESTROY] Implemented method destroy() from interface Disposable Bean was loaded on the BeanA");
    }
}
