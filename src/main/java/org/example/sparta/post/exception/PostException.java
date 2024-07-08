package org.example.sparta.post.exception;

public class PostException extends RuntimeException {
    public final Error error;

    public PostException(Error error) {
        super();
        this.error = error;
    }
}
