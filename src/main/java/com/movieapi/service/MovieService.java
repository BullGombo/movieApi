package com.movieapi.service;

import com.movieapi.dto.*;
import com.movieapi.entity.Movie;
import com.movieapi.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    // ######################################## 속성 필드 ########################################
    private final MovieRepository movieRepository;

    // ######################################## 기능 메서드 ########################################
    // ---------------------------------------- 저장 - POST ----------------------------------------
    @Transactional
    public CreateMovieResponse createMovie(CreateMovieRequest request) {
        Movie movie = new Movie(
                request.getTitle(),
                request.getDescription()
        );
        Movie savedMovie = movieRepository.save(movie);

        return new CreateMovieResponse(
                savedMovie.getId(),
                savedMovie.getTitle(),
                savedMovie.getDescription(),
                savedMovie.getCreatedAt(),
                savedMovie.getModifiedAt()
        );
    }

    // ---------------------------------------- 단건 조회 - GET ----------------------------------------
    @Transactional(readOnly = true)
    public GetMovieResponse getMovie(Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new IllegalStateException("Movie id: " + movieId + " 찾을 수 없음.")
        );
        return new GetMovieResponse(
                movie.getId(),
                movie.getTitle(),
                movie.getDescription()
        );
    }

    // ---------------------------------------- 전체 조회 - GET ----------------------------------------
    @Transactional(readOnly = true)
    public List<GetMovieResponse> getMovies() {
        List<Movie> movies = movieRepository.findAll();

        return movies.stream()
                .map(
                        movie -> new GetMovieResponse(
                                movie.getId(),
                                movie.getTitle(),
                                movie.getDescription()
                        )
                )
                .toList();

    }

    // ---------------------------------------- 수정 - PUT ----------------------------------------
    @Transactional
    public UpdateMovieResponse updateMovie(Long movieId, UpdateMovieRequest request) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new IllegalStateException("Movie id: " + movieId + " 찾을 수 없음.")
        );
        movie.updateMovie(request.getTitle(), request.getDescription());
        return new UpdateMovieResponse(
                movie.getId(),
                movie.getTitle(),
                movie.getDescription(),
                movie.getCreatedAt(),
                movie.getModifiedAt()
        );
    }

    // ---------------------------------------- 삭제 - DELETE ----------------------------------------
    @Transactional
    public void deleteMovie(Long movieId) {
        boolean exists = movieRepository.existsById(movieId);
        if (!exists) {
            throw new IllegalStateException("Movie id: " + movieId + " 찾을 수 없음.");
        }
        movieRepository.deleteById(movieId);
    }

}
