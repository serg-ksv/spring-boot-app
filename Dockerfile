FROM openjdk:11-oracle
WORKDIR  /usr/src/app/
ARG JAR_FILE=target/*.jar
ARG CSV_FILE=target/test-classes/reviews-test.csv
COPY ${JAR_FILE} ./app.jar
COPY ${CSV_FILE} src/test/resources/reviews-test.csv
EXPOSE 8081
CMD ["java", "-jar", "./app.jar"]
