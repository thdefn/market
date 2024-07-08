package org.example.sparta.post.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreatePostForm {
    @NotBlank
    public String username;
    @NotBlank
    public String title;
    @NotBlank
    public String content;
    @NotNull
    public Integer price;
}
