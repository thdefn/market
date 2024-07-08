package org.example.sparta.post.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.example.sparta.post.domain.Post;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostBriefItem {
    public Long id;
    public String username;
    public String title;
    public Integer price;

    public static PostBriefItem from(Post post) {
        return PostBriefItem.builder()
                .id(post.getId())
                .username(post.getUsername())
                .price(post.getPrice())
                .title(post.getTitle())
                .build();
    }
}
