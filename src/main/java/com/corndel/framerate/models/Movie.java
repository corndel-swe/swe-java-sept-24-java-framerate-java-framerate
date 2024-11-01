package com.corndel.framerate.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Movie {

    public static Movie of(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        var title = rs.getString("title");
        var releaseDate = rs.getString("releaseDate");
        var ageRating = rs.getString("ageRating");
        var runtime = rs.getInt("runtime");
        var imageURL = rs.getString("imageURL");
        String genreString = rs.getString("genre");
        List<Genre> genres = Genre.valueOf(genreString, ",");
        return new Movie(id, title, releaseDate, ageRating, genres, runtime, imageURL);
    }

    public enum Genre {
        Adventure,
        Action,
        Animation,
        Biography,
        Comedy,
        Crime,
        Drama,
        Family,
        Fantasy,
        History,
        Horror,
        Mystery,
        Romance,
        SciFi,
        Thriller,
        War;

        public static List<Genre> valueOf(String string, String delimiter) {
            return Arrays.stream(string.split(delimiter))
                    .map(String::trim)
                    .map(Genre::valueOf)
                    .collect(Collectors.toList());
        }
    }

    private int id;
    private String title;
    private String releaseDate;
    private String ageRating;
    private List<Genre> genres;
    private int runtime;
    private String imageURL;

    public Movie() {
    }

    public Movie(
            int id,
            String title,
            String releaseDate,
            String ageRating,
            List<Genre> genres,
            int runtime,
            String imageURL) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.ageRating = ageRating;
        this.genres = genres;
        this.runtime = runtime;
        this.imageURL = imageURL;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
