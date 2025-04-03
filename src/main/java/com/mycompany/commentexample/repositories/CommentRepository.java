package com.mycompany.commentexample.repositories;

import com.mycompany.commentexample.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
