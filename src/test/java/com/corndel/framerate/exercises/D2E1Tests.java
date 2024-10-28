package com.corndel.framerate.exercises;

import static org.assertj.core.api.Assertions.assertThat;

import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import org.jsoup.Jsoup;
import org.junit.jupiter.api.Test;

public class D2E1Tests {

  Javalin app = D2E1.createApp();

  @Test
  public void GET_includes_partial() {
    JavalinTest.test(
        app,
        (server, client) -> {
          var res = client.get("/d2e1");
          assertThat(res.code()).isEqualTo(200);
          assertThat(res.header("Content-Type")).matches("text\\/html");
          var body = res.body().string();
          var document = Jsoup.parse(body);
          var marketingText = document.select("marquee").first().text();

          var expectedMarketingText = "We have been trying to contact you about your car insurance!";
          assertThat(marketingText).isEqualTo(expectedMarketingText);
        });
  }
}
