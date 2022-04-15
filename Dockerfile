FROM openjdk:12-alpine

COPY target/forecast-analyzer.jar forecast-analyzer.jar

EXPOSE 17223

ENTRYPOINT ["java", "-jar", "-Dserver.port=17223","forecast-analyzer.jar"]