package com.mycompany.commentexample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mycompany.commentexample.proxies.CommentNotificationProxy;
import com.mycompany.commentexample.repositories.CommentRepository;
import com.mycompany.commentexample.services.CommentService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        CommentService commentService = context.getBean(CommentService.class);
        CommentNotificationProxy commentNotificationProxy = context.getBean(CommentNotificationProxy.class);
        CommentRepository commentRepository = context.getBean(CommentRepository.class);

        Comment comment = new Comment("Dat dep trai", "TQDat");
        // System.out.println(commentNotificationProxy);
        // System.out.println(commentRepository);

        commentService.publishComment(comment);

        context.close();
    } 
}
