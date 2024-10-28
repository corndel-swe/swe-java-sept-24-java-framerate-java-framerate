package com.corndel.framerate.exercises;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class D1E1 {
  public Javalin app;

  public D1E1() {
    app =
        Javalin.create(
            config -> {
              // TODO: Configure the app to serve static files from 'resources/exercises/public'

              // TODO REMOVE THIS
              config.staticFiles.add("/exercises/public", Location.CLASSPATH);
            });
  }
}
