package com.corndel.framerate.repositories;

import com.corndel.framerate.DB;
import com.corndel.framerate.models.Review;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ReviewRepository {
  public static List<Review> findByMovie(int movieId) {
    var query = "SELECT * FROM REVIEWS WHERE movieId = ?";
    List<Review> reviews = new ArrayList<>();

    try (var con = DB.getConnection();
         var stmt = con.prepareStatement(query)) {
      stmt.setInt(1, movieId);
      try (var rs = stmt.executeQuery()) {
        while (rs.next()) {
          Review review = new Review(
                  rs.getInt("id"),
                  rs.getInt("movieId"),
                  rs.getTimestamp("createdAt").getTime(),
                  rs.getString("content"),
                  rs.getInt("rating")
          );
          reviews.add(review);
        }
      }
    } catch (SQLException e) {
      System.err.println("Error finding reviews: " + e.getMessage());
    }

    return reviews;
  }

  public static void addReview(Review review) {
    String query = "INSERT INTO REVIEWS (movieId, content, rating) VALUES (?, ?, ?)";

    try (var con = DB.getConnection();
         var stmt = con.prepareStatement(query)) {
      stmt.setInt(1, review.getMovieId());
//      stmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
      stmt.setString(2, review.getContent());
      stmt.setInt(3, review.getRating());
      stmt.executeUpdate();
    } catch (SQLException e) {
      System.err.println("Error adding review: " + e.getMessage());
    }
  }
}

