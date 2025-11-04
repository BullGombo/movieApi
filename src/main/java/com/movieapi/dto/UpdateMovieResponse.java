package com.movieapi.dto;

import com.movieapi.entity.Movie;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateMovieResponse {

    private final Long id;
    private final String  title;
    private final String description;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public UpdateMovieResponse(Long id, String title, String description, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
