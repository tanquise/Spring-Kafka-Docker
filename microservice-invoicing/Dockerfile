FROM openjdk:11
EXPOSE 8080
COPY ./target/microservice-invoicing-0.0.1-SNAPSHOT.jar app-invoice.jar
ENTRYPOINT ["java","-jar","/app-invoice.jar"]