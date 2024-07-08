package org.example.sparta.post.domain;

import jakarta.persistence.*;
import lombok.*;
import org.example.sparta.post.dto.request.CreatePostForm;
import org.example.sparta.post.dto.request.UpdatePostForm;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Builder
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private int price;

    private String username;

    public static Post from(CreatePostForm form) {
        return Post.builder()
                .content(form.getContent())
                .title(form.getTitle())
                .price(form.getPrice())
                .username(form.getUsername())
                .build();
    }

    public void update(UpdatePostForm form){
        this.content = form.getContent();
        this.price = form.getPrice();
        this.title = form.getTitle();
        this.username = form.getUsername();
    }
}
