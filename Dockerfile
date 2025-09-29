FROM eclipse-temurin
ADD target/mercadonaApp.jar mercadona-app.jar
ENTRYPOINT ["java", "-jar", "/mercadona-app.jar"]