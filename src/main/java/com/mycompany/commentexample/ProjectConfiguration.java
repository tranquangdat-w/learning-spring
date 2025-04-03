package com.mycompany.commentexample;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.mycompany.commentexample.proxies", "com.mycompany.commentexample.repositories", "com.mycompany.commentexample.services" })

public class ProjectConfiguration {
}
