package com.corndel.framerate.controllers;

import com.corndel.framerate.models.Review;
import com.corndel.framerate.repositories.ReviewRepository;
import io.javalin.http.Context;

import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

public class ReviewController {

    public static void showReviewForm(Context ctx) {
        int movieId = Integer.parseInt(ctx.pathParam("movieId"));
        ctx.render("review-form.html", Map.of("movieId", movieId));
    }

    public static void addReview(Context ctx) {
        int movieId = Integer.parseInt(ctx.pathParam("movieId"));
        String content = ctx.formParam("content");
        int rating = Integer.parseInt(ctx.formParam("rating"));

        try {
            Review review = new Review(0, movieId, new Date().getTime(), content, rating);
            ReviewRepository.addReview(review);

            // Redirect back to the movie details page
            ctx.redirect("/movies/" + movieId);
        } catch (NumberFormatException e) {
            ctx.status(400).result("Invalid input. Please ensure all fields are filled in correctly.");
        }
    }
}
