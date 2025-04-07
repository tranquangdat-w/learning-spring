package com.mycompany.commentexample.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.commentexample.repositories.CommentRepository;

@Service
public class UserService {
    private CommentRepository commentRepository;

    @Autowired
	public UserService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}


	public CommentRepository getCommentRepository() {
		return commentRepository;
	}

}
