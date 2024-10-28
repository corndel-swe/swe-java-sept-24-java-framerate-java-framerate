package com.corndel.framerate.exercises;

import static org.assertj.core.api.Assertions.assertThat;

import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import java.util.List;
import java.util.stream.Collectors;
import org.jsoup.Jsoup;
import org.junit.jupiter.api.Test;

public class D1E3Tests {

  Javalin app = new D1E3().app;

  @Test
  public void GET_includes_shopping_list() {
    JavalinTest.test(
        app,
        (server, client) -> {
          var res = client.get("/d1e3");
          assertThat(res.code()).isEqualTo(200);
          assertThat(res.header("Content-Type")).matches("text\\/html");
          var body = res.body().string();
          var document = Jsoup.parse(body);
          var shoppingList =
              document.select("li").stream().map(li -> li.text()).collect(Collectors.toList());

          var expectedShoppingList =
              List.of(
                  "Eggs",
                  "Flour",
                  "Sugar",
                  "Lifesize cutout of Christian Bale as Batman",
                  "Milk",
                  "Bread");
          assertThat(shoppingList).containsExactlyInAnyOrderElementsOf(expectedShoppingList);
        });
  }
}
