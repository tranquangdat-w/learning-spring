package com.mycompany.commentexample;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mycompany.commentexample.services.CommentService;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        System.out.println("\nRunning Application:...");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        CommentService commentService = context.getBean(CommentService.class);
        Comment comment = new Comment("Hello World", "John Doe");

        // Return of the publishComment() be intercepted by the AOP
        /* String value = commentService.publishComment(commnet);

        logger.info(value); */

        commentService.deleteComment(comment);

        context.close();
    } 
}

