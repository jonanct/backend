FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "/app/app.jar"]


ENV discovery.type=single-node
ENV OPENSEARCH_JAVA_OPTS="-Xms128m -Xmx128m -XX:MaxDirectMemorySize=64m"
