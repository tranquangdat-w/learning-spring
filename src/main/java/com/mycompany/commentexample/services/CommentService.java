package com.mycompany.commentexample.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.mycompany.commentexample.Comment;
import com.mycompany.commentexample.CommentProcessor;
import com.mycompany.commentexample.proxies.CommentNotificationProxy;
import com.mycompany.commentexample.repositories.CommentRepository;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Lazy
public class CommentService {
    private CommentRepository commentRepository;
    private CommentNotificationProxy notificationProxy;

    @Autowired
    private ApplicationContext context;

	public CommentService(CommentRepository commentRepository, @Qualifier("email1") CommentNotificationProxy notificationProxy) {
		this.commentRepository = commentRepository;
		this.notificationProxy = notificationProxy;
	}

	public void publishComment(Comment comment) {
        // Save the comment to the database
        commentRepository.storeComment(comment);

        // Send the comment to the external service
        notificationProxy.sendNotifyComment(comment);
    }

    public void sendComment(Comment c) {
        CommentProcessor commentProcessor = context.getBean(CommentProcessor.class);
        System.out.println(String.format("Comment before processing: %s", commentProcessor));
        commentProcessor.setComment(c);
        commentProcessor.validateCommnet(c);
        commentProcessor.processComment(c);
        c = commentProcessor.getComment();
        System.out.println(String.format("Comment after processing: %s", c));
    }


    @Override
    public String toString() {
        return "CommentService [commentRepository=" + commentRepository + ", commentProxy=" + notificationProxy + "]";
    }

    public CommentRepository getCommentRepository() {
        return commentRepository;
    }
}
