package com.mycompany.commentexample.services;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.mycompany.commentexample.Comment;
import com.mycompany.commentexample.CommentProcessor;
import com.mycompany.commentexample.ToLog;
import com.mycompany.commentexample.proxies.CommentNotificationProxy;
import com.mycompany.commentexample.repositories.CommentRepository;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * CommentService
 */

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentService {
    private Logger logger = Logger.getLogger(CommentService.class.getName());
    private CommentRepository commentRepository;
    private CommentNotificationProxy notificationProxy;

    @Autowired
    private ApplicationContext context;

	public CommentService(CommentRepository commentRepository, @Qualifier("email1") CommentNotificationProxy notificationProxy) {
		this.commentRepository = commentRepository;
		this.notificationProxy = notificationProxy;
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

    public String publishComment(Comment comment) {
        logger.info("Publish comment: " + comment.getText());
        return "SUCCESS";
    }

    @ToLog
    public String deleteComment(Comment comment) {
        logger.info("Delete comment: " + comment.getText());
        return "SUCCESS";
    }

    public void editCommnet(Comment comment) {
        logger.info("Editing comment: " + comment.getText());
    }

    @Override
    public String toString() {
        return "CommentService [commentRepository=" + commentRepository + ", commentProxy=" + notificationProxy + "]";
    }

    public CommentRepository getCommentRepository() {
        return commentRepository;
    }
}
