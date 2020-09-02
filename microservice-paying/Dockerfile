FROM openjdk:11
EXPOSE 8081
COPY ./target/microservice-paying-0.0.1-SNAPSHOT.jar app-pay.jar
ENTRYPOINT ["java","-jar","/app-pay.jar"]