package com.corndel.framerate;

import org.junit.jupiter.api.Test;
import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;

import static org.assertj.core.api.Assertions.assertThat;

public class AppIntegrationTests {

  Javalin app = App.createApp(); // inject any dependencies you might have

  @Test
  public void GET_index_to_hello_world() {
    JavalinTest.test(app, (server, client) -> {
      var helloWorld = "Hello, World!";
      assertThat(client.get("/").code()).isEqualTo(200);
      assertThat(client.get("/").body().string()).isEqualTo(helloWorld);
    });
  }

}
