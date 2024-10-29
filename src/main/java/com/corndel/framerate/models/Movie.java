package com.corndel.framerate.models;

import java.util.List;

public class Movie {
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
    War
  }

  private int id;
  public String title;
  public String releaseDate;
  public String ageRating;
  public List<Genre> genres;
  public int runtime;
  public String imageURL;


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


  public String getTitle() {
    return title;
  }


  public String getReleaseDate() {
    return releaseDate;
  }

  public String getAgeRating() {
    return ageRating;
  }

  public List<Genre> getGenres() {
    return genres;
  }

  public int getRuntime() {
    return runtime;
  }

  public String getImageURL() {
    return imageURL;
  }
}
