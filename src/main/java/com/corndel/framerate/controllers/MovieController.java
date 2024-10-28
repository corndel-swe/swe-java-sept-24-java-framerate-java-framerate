package com.corndel.framerate.controllers;

import com.corndel.framerate.models.Movie;
import com.corndel.framerate.repositories.MovieRepository;
import io.javalin.http.Context;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MovieController {

    public static void getAllMovies(Context context) {
        try {
            List<Movie> movies = MovieRepository.findAll();
            context.render("/movies.html", Map.of("movies", movies));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getMovieById(Context context) {
        var id = context.pathParam("movieId");
        try {
            var movie = MovieRepository.findById(Integer.parseInt(id));
            if (movie == null) throw new RuntimeException();
            context.render("/movie.html", Map.of("movie", movie));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
