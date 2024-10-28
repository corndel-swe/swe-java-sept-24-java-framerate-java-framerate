package com.corndel.framerate.exercises;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.ResourceCodeResolver;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import java.util.Collections;

public class D1E2 {
  public Javalin app;

  public D1E2() {
    app =
        Javalin.create(
            config -> {
              var codeResolver = new ResourceCodeResolver("exercises/templates");
              var templateEngine = TemplateEngine.create(codeResolver, ContentType.Html);
              config.fileRenderer(new JavalinJte(templateEngine));
            });
    app.get(
        "/d1e2",
        ctx -> {
          var message = "Hello from d1e2!";

          // TODO: Render 'd1e2.jte' and pass the msg
          // TODO: Open d1e2.jte and follow the instructions

          // TODO remove answer
          ctx.render("d1e2.jte", Collections.singletonMap("message", message));
        });
  }
}
