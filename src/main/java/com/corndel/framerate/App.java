package com.corndel.framerate;

import com.corndel.framerate.controllers.MovieController;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.template.JavalinThymeleaf;


public class App {
  public static void main(String[] args) {
    var javalin = createApp();
    javalin.start(8081);
  }

  public static Javalin createApp() {
    var app = Javalin.create(
        config -> {
          config.staticFiles.add("/exercises/public", Location.CLASSPATH);

          var resolver = new ClassLoaderTemplateResolver();
          resolver.setPrefix("/exercises/templates/");
          resolver.setSuffix(".html");
          resolver.setTemplateMode("HTML");

          var engine = new TemplateEngine();
          engine.setTemplateResolver(resolver);

          config.fileRenderer(new JavalinThymeleaf(engine));
        });

      app.get("/", MovieController::getAllMovies);
      app.get("/movies/{id}", MovieController::getMovieDetails);






      //      app.get("/d2e1", ctx -> {
//          ctx.status(200).render("d2e1.html");
//      });
//      app.get("/d2e2", ctx -> {
//          ctx.status(200).render("d2e2.html");
//      });
//      app.get("/d2e3", ctx -> {
//          ctx.status(200).render("d2e3.html");
//      });
//
//      app.post("/submit", ctx -> {
//
//          String name = ctx.formParam("name");
//          String email = ctx.formParam("email");
//
//          ctx.result("Received: " + name + ", " + email);
//      });

      return app;
  }
}
