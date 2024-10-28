# FrameRate

Remember FrameRate? It's BACK and better than ever!

<p align="center">
  <img src="./src/main/resources/public/images/logo.png" width="300px" alt="FrameRate logo" />
</p>

This web application is all about creating and sharing anonymous movie reviews
with other users.

## Getting started

1. Clone your fork of the repo

1. Run the command

   ```bash
   ./mvnw clean && ./mvnw compile && ./mvnw exec:java -Dexec.mainClass=com.corndel.framerate.App
   ```

   and visit [http://localhost:8081/](http://localhost:8081/) in your browser.

1. Run

   ```bash
   ./mvnw flyway:migrate
   ```

   to set up and seed the database.

## Day 1

### Deep dive

> [!NOTE]
>
> You can test the exercises by running, for example,
>
> ```bash
> ./mvnw test -Dtest=D1E1Tests
> ```

1. Read about
   [static files](https://tech-docs.corndel.com/javalin/static-files.html)

2. Solve and push
   [D1E1.java](./src/main/java/com/corndel/framerate/exercises/D1E1.java)

3. Read about
   [views and templates](https://tech-docs.corndel.com/javalin/views-and-templates.html)

4. Solve and push
   [D1E2.java](./src/main/java/com/corndel/framerate/exercises/D1E2.java) and
   [d1e2.html](./src/main/resources/exercises/templates/d1e2.html)

5. Read about
   [using loops](https://tech-docs.corndel.com/javalin/using-loops.html)

6. Solve and push
   [D1E3.java](./src/main/java/com/corndel/framerate/exercises/D1E3.java) and
   [d1e3.html](./src/main/resources/exercises/templates/d1e3.html)

### Workshop

Head to `CONTRIBUTING.md` to see what to do next

## Day 2

### Deep dive

1. Read about
   [template partials](https://tech-docs.corndel.com/javalin/template-partials.html)

2. Solve and push
   [D2E1.java](./src/main/java/com/corndel/framerate/exercises/D2E1.java) and
   [d2e1.html](./src/main/resources/exercises/templates/d2e1.html)

3. Read about
   [CSS and assets](https://tech-docs.corndel.com/javalin/css-and-assets.html)

4. Solve and push
   [D2E2.java](./src/main/java/com/corndel/framerate/exercises/D2E2.java) and
   [d2e2.html](./src/main/resources/exercises/templates/d2e2.html)

5. Read about
   [user input](https://tech-docs.corndel.com/javalin/user-input.html)

6. Solve and push
   [D2E3.java](./src/main/java/com/corndel/framerate/exercises/D2E3.java) and
   [d2e3.html](./src/main/resources/exercises/templates/d2e3.html)

### Workshop

Head back to `CONTRIBUTING.md` to see what's next!
