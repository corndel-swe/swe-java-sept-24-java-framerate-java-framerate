package com.corndel.framerate.exercises;

import io.javalin.Javalin;

public class D1E1 {

  public static Javalin createApp() {
    var app = Javalin.create(
        config -> {
          // TODO: Configure the app to serve static files from
          // 'resources/exercises/public'
        });

    return app;
  }
}
