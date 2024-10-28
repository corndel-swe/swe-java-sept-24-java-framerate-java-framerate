package com.corndel.framerate.exercises;

import static org.assertj.core.api.Assertions.assertThat;

import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import org.jsoup.Jsoup;
import org.junit.jupiter.api.Test;

public class D2E2Tests {

  Javalin app = new D2E2().app;

  @Test
  public void GET_includes_image() {
    JavalinTest.test(
        app,
        (server, client) -> {
          var res = client.get("/d2e2");
          assertThat(res.code()).isEqualTo(200);
          assertThat(res.header("Content-Type")).matches("text\\/html");
          var body = res.body().string();
          var document = Jsoup.parse(body);
          var imgSrc = document.select("img").first().attr("src");

          var imgRes = client.get(imgSrc);
          assertThat(imgRes.code()).isEqualTo(200);
          assertThat(imgRes.header("Content-Type")).matches("image\\/jpeg");
          assertThat(imgRes.body().bytes()).isNotEmpty();
        });
  }

  @Test
  public void GET_includes_alt_text() {
    JavalinTest.test(
        app,
        (server, client) -> {
          var res = client.get("/d2e2");
          assertThat(res.code()).isEqualTo(200);
          assertThat(res.header("Content-Type")).matches("text\\/html");
          var body = res.body().string();
          var document = Jsoup.parse(body);
          var altText = document.select("img").first().attr("alt");

          assertThat(altText.toLowerCase()).isEqualTo("success kid");
        });
  }
}
