package org.example.sparta.post.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum Error {
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "게시물이 존재하지 않습니다.");
    public final HttpStatus httpStatus;
    public final String message;
}
