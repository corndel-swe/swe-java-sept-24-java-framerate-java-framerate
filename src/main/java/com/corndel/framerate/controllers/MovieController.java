package com.corndel.framerate.controllers;

import com.corndel.framerate.models.MovieTile;
import com.corndel.framerate.repositories.MovieRepository;
import com.corndel.framerate.repositories.ReviewRepository;
import io.javalin.http.Context;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class MovieController {

    private final  MovieRepository movieRepository ;
    private final  ReviewRepository reviewRepository;

    public MovieController(MovieRepository movieRepository, ReviewRepository reviewRepository) {
        this.movieRepository = movieRepository;
        this.reviewRepository = reviewRepository;
    }

    public  void getAllMovies(Context context) {
        try {
            List<MovieTile> movies = movieRepository.findAllMovies();
            context.render("/movies.html", Map.of("movieTiles", movies));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public  void getMovieById(Context context) {
        var id = context.pathParam("movieId");
        try {
            var movie = movieRepository.findById(Integer.parseInt(id));
            if (movie == null) {
                context.render("/error.html" );
                return;
            }
            var reviews = reviewRepository.findByMovieId(Integer.parseInt(id));
            context.render("/movie.html", Map.of("movie", movie, "reviews", reviews));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
