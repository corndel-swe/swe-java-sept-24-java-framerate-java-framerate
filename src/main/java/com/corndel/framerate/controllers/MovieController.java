package com.corndel.framerate.controllers;

import io.javalin.http.Context;
import com.corndel.framerate.models.Movie;
import com.corndel.framerate.models.Review;
import com.corndel.framerate.repositories.MovieRepository;
import com.corndel.framerate.repositories.ReviewRepository;

import java.util.List;
import java.util.Map;

public class MovieController {

    public static void getAllMovies(Context ctx) {
        try {
            List<Movie> movies = MovieRepository.findAll();
            if (movies.isEmpty()) {
                ctx.status(204);
            } else {
                ctx.status(200).render("index.html", Map.of("movies", movies));
            }
        } catch (Exception e) {
            ctx.status(500).result("An internal server error occurred.");
        }
    }

    public static void getMovieDetails(Context ctx) {
        try {
            int id = Integer.parseInt(ctx.pathParam("id"));
            Movie movie = MovieRepository.findById(id);

            if (movie == null) {
                ctx.status(404).result("Movie not found.");
                return;
            }

            List<Review> reviews = ReviewRepository.findByMovie(id);
            ctx.status(200).render("movie-reviews.html", Map.of("movie", movie, "reviews", reviews));

        } catch (NumberFormatException e) {
            ctx.status(400).result("Invalid movie ID format.");
        } catch (Exception e) {
            ctx.status(500).result("An internal server error occurred.");
        }
    }
}