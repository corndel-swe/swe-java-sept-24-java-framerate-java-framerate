package com.corndel.framerate.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.corndel.framerate.DB;
import com.corndel.framerate.models.Movie;
import com.corndel.framerate.models.Movie.Genre;
import com.corndel.framerate.models.MovieTile;

public class MovieRepository extends Repository {

    private final Function<ResultSet, Movie> movieMapper = (ResultSet rs) -> {
        try {
            return Movie.of(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };

    private final Function<ResultSet, MovieTile> movieTileMapper = (ResultSet rs) -> {
        try {
            return MovieTile.of(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };

    public List<MovieTile> findAllMovies() throws SQLException {
        var query = "SELECT * FROM MOVIES";
        return findAll(query, movieTileMapper);
    }

    public Movie findById(int id) throws SQLException {
        var query = "SELECT * FROM MOVIES WHERE id = ?";
        return findByInt(query, id, movieMapper);
    }
}
