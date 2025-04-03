package com.mycompany.commentexample.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.commentexample.Comment;
import com.mycompany.commentexample.proxies.CommentNotificationProxy;
import com.mycompany.commentexample.repositories.CommentRepository;

@Component
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentNotificationProxy commentProxy;

	public CommentService(CommentRepository commentRepository, CommentNotificationProxy commentProxy) {
		this.commentRepository = commentRepository;
		this.commentProxy = commentProxy;
	}

	public void publishComment(Comment comment) {
        // Save the comment to the database
        commentRepository.storeComment(comment);

        // Send the comment to the external service
        commentProxy.sendNotifyComment(comment);
    }

    @Override
    public String toString() {
        return "CommentService [commentRepository=" + commentRepository + ", commentProxy=" + commentProxy + "]";
    }
}
