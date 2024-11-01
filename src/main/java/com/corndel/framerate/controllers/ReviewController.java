package com.corndel.framerate.controllers;

import com.corndel.framerate.models.Movie;
import com.corndel.framerate.models.Review;
import com.corndel.framerate.repositories.MovieRepository;
import com.corndel.framerate.repositories.ReviewRepository;
import io.javalin.http.Context;

import java.sql.SQLException;
import java.util.Map;

public class ReviewController {

    private final MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;

    public ReviewController(MovieRepository movieRepository, ReviewRepository reviewRepository) {
        this.movieRepository = movieRepository;
        this.reviewRepository = reviewRepository;
    }

    public void getReview(Context context) {
        var id = context.pathParam("movieId");
        try {
            Movie movie = movieRepository.findById(Integer.parseInt(id));

            context.render("create-review.html", Map.of("movie", movie, "review", new Review()));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void createReview(Context context) {
        var id = context.pathParam("movieId");
        try {
            Movie movie = movieRepository.findById(Integer.parseInt(id));
            if (movie == null) {
                context.render("/error.html" );
                return;
            }
            var rating = context.formParamAsClass("rating", Integer.class).get();
            var content = context.formParam("content");
            System.out.println(rating);
            System.out.println(content);
            reviewRepository.create(Integer.parseInt(id),content, rating);
            context.redirect("/" + id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
