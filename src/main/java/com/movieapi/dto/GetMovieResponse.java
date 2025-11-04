package com.movieapi.dto;

import lombok.Getter;

@Getter
public class GetMovieResponse {

    private final Long id;
    private final String title;
    private final String description;

    public GetMovieResponse(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
