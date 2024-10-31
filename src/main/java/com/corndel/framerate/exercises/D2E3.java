package com.corndel.framerate.exercises;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IContext;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.template.JavalinThymeleaf;

import java.util.Map;


public class D2E3 {
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

        app.get(
                "/d2e3",
                ctx -> {
                    ctx.render("d2e3.html", Map.of( "user", new User()));
                });

        app.get(
                "/success",
                ctx -> {
                    ctx.result("Success");
                });

        app.post(
                "/submit",
                ctx -> {

                    var name = ctx.formParam("name");
                    var email = ctx.formParam("email");


                    if (name.equalsIgnoreCase("charlie")) {
                        ctx.render("d2e3.html", Map.of("error", "No Charlie's Allowed", "user", new User(name, email)));
                    } else {
                        ctx.redirect("/success");
                    }


                });

        return app;
    }

    public static void main(String[] args) {
        var javalin = createApp();
        javalin.start(8081);
    }
}

class User {
    private String name = "";
    private String email = "";

    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
