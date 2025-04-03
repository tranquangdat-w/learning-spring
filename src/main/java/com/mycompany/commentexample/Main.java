package com.mycompany.commentexample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mycompany.commentexample.proxies.EmailNotificationProxy;
import com.mycompany.commentexample.repositories.CommentRepository;
// import com.mycompany.commentexample.proxies.CommentNotificationProxy;
// import com.mycompany.commentexample.repositories.CommentRepository;
import com.mycompany.commentexample.services.CommentService;
import com.mycompany.commentexample.services.UserService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        CommentService commentService = context.getBean("commentService", CommentService.class);


        Comment c2 = new Comment("Commnet1", "Tran Quang Dat");
        commentService.sendComment(c2);

        Comment c1 = new Comment("Commnet2", "Tran Quang Dat");
        commentService.sendComment(c1);

        context.close();
    } 
}
