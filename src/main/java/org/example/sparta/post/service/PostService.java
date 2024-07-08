package org.example.sparta.post.service;

import lombok.RequiredArgsConstructor;
import org.example.sparta.post.domain.Post;
import org.example.sparta.post.domain.repository.PostRepository;
import org.example.sparta.post.dto.request.CreatePostForm;
import org.example.sparta.post.dto.request.PostItem;
import org.example.sparta.post.dto.request.PostBriefItem;
import org.example.sparta.post.dto.request.UpdatePostForm;
import org.example.sparta.post.dto.response.DeletePostResponse;
import org.example.sparta.post.exception.Error;
import org.example.sparta.post.exception.PostException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public PostItem create(CreatePostForm form) {
        return PostItem.from(postRepository.save(Post.from(form)));
    }

    public List<PostBriefItem> retrieve() {
        return postRepository.findByOrderById()
                .stream().map(PostBriefItem::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public PostItem updateById(Long postId, UpdatePostForm form) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostException(Error.POST_NOT_FOUND));
        post.update(form);
        return PostItem.from(post);
    }

    @Transactional
    public DeletePostResponse deleteById(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostException(Error.POST_NOT_FOUND));
        postRepository.delete(post);
        return new DeletePostResponse();
    }


}
