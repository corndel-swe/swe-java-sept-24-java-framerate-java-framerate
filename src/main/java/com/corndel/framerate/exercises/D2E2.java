package com.corndel.framerate.exercises;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.ResourceCodeResolver;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.template.JavalinJte;

public class D2E2 {
  public Javalin app;

  public D2E2() {
    app =
        Javalin.create(
            config -> {
              var codeResolver = new ResourceCodeResolver("exercises/templates");
              var templateEngine = TemplateEngine.create(codeResolver, ContentType.Html);
              config.staticFiles.add("/exercises/public", Location.CLASSPATH);
              config.fileRenderer(new JavalinJte(templateEngine));
            });

    app.get(
        "/d2e2",
        ctx -> {
          // TODO: Render 'd2e2.jte'

          // TODO: Open d2e2.jte and follow the instructions

          // TODO Remove answer
          ctx.render("d2e2.jte");
        });
  }
}
