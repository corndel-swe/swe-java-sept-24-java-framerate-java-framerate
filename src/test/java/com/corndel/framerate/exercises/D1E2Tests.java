package com.corndel.framerate.exercises;

import static org.assertj.core.api.Assertions.assertThat;

import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import org.jsoup.Jsoup;
import org.junit.jupiter.api.Test;

public class D1E2Tests {

  Javalin app = new D1E2().app;

  @Test
  public void GET_includes_message() {
    JavalinTest.test(
        app,
        (server, client) -> {
          var res = client.get("/d1e2");
          assertThat(res.code()).isEqualTo(200);
          assertThat(res.header("Content-Type")).matches("text\\/html");
          var body = res.body().string();
          var document = Jsoup.parse(body);
          var titleText = document.select("h1").first().text();
          assertThat(titleText).isEqualTo("Hello from d1e2!");
        });
  }
}
