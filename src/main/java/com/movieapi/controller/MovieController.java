package com.movieapi.controller;

import com.movieapi.dto.*;
import com.movieapi.entity.Movie;
import com.movieapi.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    // ---------------------------------------- 저장 - POST ----------------------------------------
    @PostMapping("/movies")
    public ResponseEntity<CreateMovieResponse> createMovie(@RequestBody CreateMovieRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.createMovie(request));
    }

    // ---------------------------------------- 단건 조회 - GET ----------------------------------------
    @GetMapping("/movies/{movieId}")
    public ResponseEntity<GetMovieResponse> getMovie(@PathVariable Long movieId) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getMovie(movieId));
    }

    // ---------------------------------------- 다건 조회 - GET ----------------------------------------
    @GetMapping("/movies")
    public ResponseEntity<List<GetMovieResponse>> getAllMovies() {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getMovies());
    }

    // ---------------------------------------- 수정 - PUT ----------------------------------------
    @PutMapping("/movies/{movieId}")
    public ResponseEntity<UpdateMovieResponse> updateMovie(@PathVariable Long movieId, @RequestBody UpdateMovieRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.updateMovie(movieId, request));
    }

    // ---------------------------------------- 삭제 - DELETE ----------------------------------------
    @DeleteMapping("/movies/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long movieId) {
        movieService.deleteMovie(movieId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
