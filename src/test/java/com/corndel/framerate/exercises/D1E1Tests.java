package com.corndel.framerate.exercises;

import static org.assertj.core.api.Assertions.assertThat;

import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import org.junit.jupiter.api.Test;

public class D1E1Tests {

  Javalin app = D1E1.createApp();

  @Test
  public void GET_success_image() {
    JavalinTest.test(
        app,
        (server, client) -> {
          var res = client.get("/success.jpg");
          assertThat(res.code()).isEqualTo(200);
          assertThat(res.header("Content-Type")).matches("image\\/jpeg");
          assertThat(res.body().bytes()).isNotEmpty();
        });
  }
}
