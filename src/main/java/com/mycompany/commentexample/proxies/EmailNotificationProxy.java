package com.mycompany.commentexample.proxies;

import org.springframework.stereotype.Component;
import com.mycompany.commentexample.Comment;

@Component
public class EmailNotificationProxy implements CommentNotificationProxy {
    public EmailNotificationProxy() {
    }
    @Override
    public void sendNotifyComment(Comment comment) {
        System.out.println("Sending email notification for comment: " + comment.getText());
    }

	@Override
	public String toString() {
		return "EmailNotificationProxy []";
	}
    
}
