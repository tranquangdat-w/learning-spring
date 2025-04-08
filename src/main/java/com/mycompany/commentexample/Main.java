package com.mycompany.commentexample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// import com.mycompany.commentexample.proxies.CommentNotificationProxy;
// import com.mycompany.commentexample.repositories.CommentRepository;
import com.mycompany.commentexample.services.CommentService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        CommentService commentService = context.getBean("commentService", CommentService.class);
        System.out.println("\n");
        Comment c = new Comment("hello", "John Doe");
        commentService.publishComment(c);
        context.close();
    } 
}
