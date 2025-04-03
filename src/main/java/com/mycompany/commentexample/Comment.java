package com.mycompany.commentexample;

public class Comment {
    private String text;
    private String author;

    public Comment(String text, String author) {
        this.text = text;
        this.author = author;
    }

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Comment [text=" + text + ", author=" + author + "]";
	}
}
