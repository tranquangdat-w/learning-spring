package com.mycompany.commentexample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Lazy;

import com.mycompany.commentexample.proxies.CommentNotificationProxy;
import com.mycompany.commentexample.proxies.EmailNotificationProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "com.mycompany.commentexample.proxies", "com.mycompany.commentexample.repositories", "com.mycompany.commentexample.services", "com.mycompany.commentexample", "com.mycompany.commentexample.aspects" })
public class ProjectConfiguration {
    @Bean
    @Lazy
    public CommentNotificationProxy email1() {
        return new EmailNotificationProxy(); 
    }
}

