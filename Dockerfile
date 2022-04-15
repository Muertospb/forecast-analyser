FROM openjdk:11-alpine

COPY target/forecast-analyzer.jar forecast-analyzer.jar

EXPOSE 17223

ENTRYPOINT ["java", "-jar", "forecast-analyzer.jar"]