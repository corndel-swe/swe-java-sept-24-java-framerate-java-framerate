package com.corndel.framerate.models;


import java.sql.ResultSet;
import java.sql.SQLException;

// CHANGE IT
// - REVIEW MODEL
// - DTO - DATA TRANSFER OBJECT
// - POJO - DEFAULT CONSTRUCTOR AND GETTERS AND SETTERS
public class Review {



    public static Review of(ResultSet rs) throws SQLException {
        var id = rs.getInt("id");
        var content = rs.getString("content");
        var ts = rs.getTimestamp("createdAt").getTime();
        var movieId = rs.getInt("movieId");
        var rating = rs.getInt("rating");
        return new Review(id, movieId, ts, content, rating);
    }

    private int id;
    private int movieId;
    private long createdAt;
    private String content;
    private int rating;

    public Review() {
    }

    public Review(int id, int movieId, long createdAt, String content, int rating) {
        this.id = id;
        this.movieId = movieId;
        this.createdAt = createdAt;
        this.content = content;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}


