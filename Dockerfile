FROM eclipse-temurin
ADD target/mercadona-app.jar mercadona-app.jar
ENTRYPOINT ["java", "-jar", "/mercadona-app.jar"]