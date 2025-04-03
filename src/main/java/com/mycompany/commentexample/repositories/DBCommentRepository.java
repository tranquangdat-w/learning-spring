package com.mycompany.commentexample.repositories;

import org.springframework.stereotype.Component;
import com.mycompany.commentexample.Comment;

@Component
public class DBCommentRepository implements CommentRepository {
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment in the database: " + comment.getText());
    }

	@Override
	public String toString() {
		return "DBCommentRepository []";
	}
    
}
