FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/order-service-0.0.1-SNAPSHOT.jar order-service-app.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","order-service-app.jar"]