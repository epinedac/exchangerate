FROM openjdk:17-jdk-alpine
VOLUME /tmp
ADD target/ExchangeRate.jar ExchangeRate.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/ExchangeRate.jar"]