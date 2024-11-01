package com.corndel.framerate.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieTile {
    public static MovieTile of(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        var title = rs.getString("title");
        var imageURL = rs.getString("imageURL");
        return new MovieTile(id, title, imageURL);
    }

    private int id;
    private String title;
    private String imageURL;

    public MovieTile() {
    }

    public MovieTile(int id, String title, String imageURL) {
        this.id = id;
        this.title = title;
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
