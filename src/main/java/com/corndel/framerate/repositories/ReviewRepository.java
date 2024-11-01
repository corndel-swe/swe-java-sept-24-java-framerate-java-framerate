package com.corndel.framerate.repositories;

import com.corndel.framerate.DB;
import com.corndel.framerate.models.Movie;
import com.corndel.framerate.models.Review;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ReviewRepository extends Repository {
    private final Function<ResultSet, Review> reviewMapper = (ResultSet rs) -> {
        try {
            return Review.of(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };

    public List<Review> findByMovieId(int movieId) throws SQLException {
        var query = "SELECT * FROM REVIEWS WHERE movieId = ?";
        return findAllByInt(query, movieId, reviewMapper);
    }

    public Review create(int movieId, String content, int rating) throws SQLException {
        String query = "INSERT INTO REVIEWS (movieId,content,rating) VALUES(?,?,?) RETURNING *";

        try (var connection = DB.getConnection();
             var statement = connection.prepareStatement(query)) {
            statement.setInt(1, movieId);
            statement.setString(2, content);
            statement.setInt(3, rating);

            try (var rs = statement.executeQuery();) {
                return !rs.next() ? null : Review.of(rs);
            }
        }
    }
}
