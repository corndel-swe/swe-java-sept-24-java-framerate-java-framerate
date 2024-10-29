package com.corndel.framerate.exercises;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.template.JavalinThymeleaf;

public class D2E2 {
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

      app.get("/d2e2", ctx -> {
          ctx.status(200).render("d2e2.html");
      });

    return app;
  }
}
