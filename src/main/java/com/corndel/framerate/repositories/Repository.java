package com.corndel.framerate.repositories;


import com.corndel.framerate.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class Repository {

    // CREATE

    // READ

    public <T> List<T> findAll(String query, Function<ResultSet, T> mapper) throws SQLException {

        try (Connection connection = DB.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);) {

            List<T> all = new ArrayList<>();

            while (resultSet.next()) {
                all.add(mapper.apply(resultSet));
            }

            return all;
        }
    }

    public <T> T findByInt(String query, int i, Function<ResultSet, T> mapper) throws SQLException {
        try (Connection con = DB.getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, i);

            try (ResultSet rs = stmt.executeQuery()) {
                return !rs.next() ? null : mapper.apply(rs);
            }
        }
    }

    public <T> List<T> findAllByInt(String query, int i, Function<ResultSet, T> mapper) throws SQLException {
        try (Connection con = DB.getConnection();
             PreparedStatement stmt = con.prepareStatement(query);
        ) {
            stmt.setInt(1, i);

            try (ResultSet resultSet = stmt.executeQuery()) {
                List<T> all = new ArrayList<>();

                while (resultSet.next()) {
                    all.add(mapper.apply(resultSet));
                }

                return all;
            }
        }
    }

    // UPDATE

    // DELETE
}