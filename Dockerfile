FROM openjdk:8-jdk-alpine

COPY target/forecast-analyzer.jar forecast-analyzer.jar

EXPOSE 17223

ENTRYPOINT ["java", "-jar", "forecast-analyzer.jar"]