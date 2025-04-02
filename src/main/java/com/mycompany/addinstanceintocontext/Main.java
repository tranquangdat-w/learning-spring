package com.mycompany.addinstanceintocontext;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // context.registerBean("parrot1", Parrot.class, () -> new Parrot("Kiki"), bc -> bc.setPrimary(true));
        // context.registerBean("parrot2", Parrot.class, () -> new Parrot("Koko"));
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
        context.close();
    } 
}

