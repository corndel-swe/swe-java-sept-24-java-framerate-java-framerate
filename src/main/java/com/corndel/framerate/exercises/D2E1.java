package com.corndel.framerate.exercises;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.ResourceCodeResolver;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

public class D2E1 {
  public Javalin app;

  public D2E1() {
    app =
        Javalin.create(
            config -> {
              var codeResolver = new ResourceCodeResolver("exercises/templates");
              var templateEngine = TemplateEngine.create(codeResolver, ContentType.Html);
              config.fileRenderer(new JavalinJte(templateEngine));
            });

    app.get(
        "/d2e1",
        ctx -> {
          // TODO: Render 'd2e1.jte'

          // TODO: Open d2e1.jte and follow the instructions

          // TODO Remove answer
          ctx.render("d2e1.jte");
        });
  }
}
