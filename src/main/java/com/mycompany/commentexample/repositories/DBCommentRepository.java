package com.mycompany.commentexample.repositories;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.config.BeanDefinition;

import com.mycompany.commentexample.Comment;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class DBCommentRepository implements CommentRepository {
    public DBCommentRepository() {
    }
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment in the database: " + comment.getText());
    }

	@Override
	public String toString() {
		return "DBCommentRepository []";
	}
    
}
