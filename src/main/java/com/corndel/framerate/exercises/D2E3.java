package com.corndel.framerate.exercises;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.ResourceCodeResolver;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.template.JavalinJte;

public class D2E3 {
  public Javalin app;

  public D2E3() {
    app =
        Javalin.create(
            config -> {
              var codeResolver = new ResourceCodeResolver("exercises/templates");
              var templateEngine = TemplateEngine.create(codeResolver, ContentType.Html);
              config.staticFiles.add("/exercises/public", Location.CLASSPATH);
              config.fileRenderer(new JavalinJte(templateEngine));
            });

    app.get(
        "/d2e3",
        ctx -> {
          ctx.render("d2e3.jte");
        });

    app.post(
        "/submit",
        ctx -> {
          // TODO: get the `name` and `email` from the form
          // so that the below response works

          // TODO: Remove answer
          var name = ctx.formParam("name");
          var email = ctx.formParam("email");

          ctx.result("Received: " + name + ", " + email);
        });
  }
}
