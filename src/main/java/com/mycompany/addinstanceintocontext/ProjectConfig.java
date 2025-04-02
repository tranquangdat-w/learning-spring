package com.mycompany.addinstanceintocontext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "com.mycompany.addinstanceintocontext")
public class ProjectConfig {
    @Bean
    public Parrot parrot1() {
        Parrot p = new Parrot("parrot1 context");

        return p;
    }
}
