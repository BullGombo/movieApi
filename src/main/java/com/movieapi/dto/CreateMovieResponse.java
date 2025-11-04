package com.movieapi.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateMovieResponse {

    private final long id;
    private final String title;
    private final String description;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CreateMovieResponse(long id, String title, String description, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
