FROM openjdk:12-alpine

COPY target/forecast-analyzer.jar forecast-analyzer.jar

EXPOSE 17223
EXPOSE 5432

ENTRYPOINT ["java", "-jar", "forecast-analyzer.jar"]