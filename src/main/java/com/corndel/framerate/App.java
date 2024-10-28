package com.corndel.framerate;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class App {
  private Javalin app;

  public static void main(String[] args) {
    var javalin = new App().javalinApp();
    javalin.start(8080);
  }

  public App() {
    app = Javalin.create(
        config -> config.staticFiles.add("/public", Location.CLASSPATH));
    app.get("/hello", ctx -> ctx.result("Welcome to the Bleeter server!"));
  }

  public Javalin javalinApp() {
    return app;
  }
}
