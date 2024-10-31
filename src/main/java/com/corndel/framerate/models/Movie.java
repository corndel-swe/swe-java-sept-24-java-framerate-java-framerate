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
  // HOW HAND HANDLE A NULL VALUE
  public Review review = null;

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

  public Movie(int id, String title, String releaseDate, String ageRating, List<Genre> genres, int runtime, String imageURL, Review review) {
    this.id = id;
    this.title = title;
    this.releaseDate = releaseDate;
    this.ageRating = ageRating;
    this.genres = genres;
    this.runtime = runtime;
    this.imageURL = imageURL;
    this.review = review;
  }


  public static void main(String[] args) {
    Movie movie = new Movie();
    movie = new Movie(2, "Iron Giant", )
  }
}
