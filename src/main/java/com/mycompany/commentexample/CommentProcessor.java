package com.mycompany.commentexample;

import org.springframework.stereotype.Component;

import com.mycompany.commentexample.repositories.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentProcessor {
    private Comment comment;

    @Autowired
    private CommentRepository commentRepository;

	@Override
	public String toString() {
		return "CommentProcessor [comment=" + comment + "]";
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

    public void processComment(Comment c) {
    }

    public void validateCommnet(Comment c) {
    }
}
