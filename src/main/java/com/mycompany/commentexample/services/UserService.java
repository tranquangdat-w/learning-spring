package com.mycompany.commentexample.services;

import org.springframework.stereotype.Service;

import com.mycompany.commentexample.repositories.CommentRepository;

@Service
public class UserService {
    private CommentRepository commentRepository;

    // Spring Auto add Autowired
	public UserService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}


	public CommentRepository getCommentRepository() {
		return commentRepository;
	}

}
