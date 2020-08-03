FROM openjdk:11-oracle
WORKDIR  /usr/src/app/
ARG JAR_FILE=target/spring-boot-app-0.0.1-SNAPSHOT.jar
ARG CSV_FILE=target/test-classes/reviews-test.csv
COPY ${JAR_FILE} ./app.jar
COPY ${CSV_FILE} src/test/resources/reviews-test.csv
EXPOSE 8081
CMD ["java", "-jar", "./app.jar"]
