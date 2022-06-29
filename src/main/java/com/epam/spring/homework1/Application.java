package com.epam.spring.homework1;

import com.epam.spring.homework1.config.BeansConfig;
import com.epam.spring.homework1.config.PetConfig;
import com.epam.spring.homework1.pet.Cheetah;
import com.epam.spring.homework1.pet.Pet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        {
            ApplicationContext apc = new AnnotationConfigApplicationContext(BeansConfig.class);
            apc.getBean(Pet.class).printPets();
        }
        {
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PetConfig.class);
            System.out.println(applicationContext.getBeansOfType(Cheetah.class));
        }
        {
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PetConfig.class);
            System.out.println(applicationContext.getBean("cheetah").hashCode() + " Base");
            System.out.println(applicationContext.getBean("getCheetah").hashCode() + " Primary");
            System.out.println(applicationContext.getBean("getAnotherCheetah").hashCode() + " Qualifier");
            System.out.println(applicationContext.getBean(Cheetah.class).hashCode()); // primary bean is loaded
            System.out.println(applicationContext.getBean("getQualifierCheetah").hashCode()); // qualifier bean is loaded
        }
    }
}