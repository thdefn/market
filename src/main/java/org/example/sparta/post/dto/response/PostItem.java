package org.example.sparta.post.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.example.sparta.post.domain.Post;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostItem {
    public Long id;
    public String username;
    public String title;
    public String content;
    public Integer price;
    public static PostItem from(Post post) {
        return PostItem.builder()
                .id(post.getId())
                .username(post.getUsername())
                .price(post.getPrice())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }
}
