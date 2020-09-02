FROM openjdk:11
EXPOSE 8080
COPY ./target/microservice-transaction-0.0.1-SNAPSHOT.jar app-transaction.jar
ENTRYPOINT ["java","-jar","/app-transaction.jar"]