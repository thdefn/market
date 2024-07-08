package org.example.sparta.post.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.sparta.post.dto.request.CreatePostForm;
import org.example.sparta.post.dto.request.PostBriefItem;
import org.example.sparta.post.dto.response.DeletePostResponse;
import org.example.sparta.post.dto.request.PostItem;
import org.example.sparta.post.dto.request.UpdatePostForm;
import org.example.sparta.post.exception.PostException;
import org.example.sparta.post.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostItem> create(@Valid @RequestBody CreatePostForm form) {
        return ResponseEntity.ok(postService.create(form));
    }

    @GetMapping
    public ResponseEntity<List<PostBriefItem>> retrieve() {
        return ResponseEntity.ok(postService.retrieve());
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostItem> update(@PathVariable Long postId, @Valid @RequestBody UpdatePostForm form) {
        return ResponseEntity.ok(postService.updateById(postId, form));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<DeletePostResponse> delete(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.deleteById(postId));
    }

    @ExceptionHandler(PostException.class)
    public ResponseEntity<Map<String, String>> handlePostException(PostException e) {
        return new ResponseEntity<>(Map.of("msg", e.error.message), e.error.httpStatus);
    }

}
