package com.mycompany.addinstanceintocontext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "com.mycompany.addinstanceintocontext")
public class ProjectConfig {
    @Bean    
    @Primary
    public Parrot parrot1() {
        Parrot parrot = new Parrot("Keke");

        return parrot;
    }
    
    @Bean
    public Parrot parrot2() {
        Parrot parrot = new Parrot("Koko");

        return parrot;
    }

    @Bean
    public Person person() {
        return new Person("John");
    }
}
