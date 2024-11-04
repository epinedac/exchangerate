FROM openjdk:17-jdk-alpine
VOLUME /tmp
ADD target/demo.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/demo.jar"]