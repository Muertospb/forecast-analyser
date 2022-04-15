FROM openjdk:11.0.10-jre-nanoserver

COPY target/forecast-analyzer.jar forecast-analyzer.jar

EXPOSE 17223

ENTRYPOINT ["java", "-jar", "forecast-analyzer.jar"]