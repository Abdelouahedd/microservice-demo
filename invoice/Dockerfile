#FROM maven:3-openjdk-11  as builder
#WORKDIR /invoice
#COPY pom.xml pom.xml
#COPY src src
#RUN mvn --batch-mode compile
#RUN mvn --batch-mode package



FROM openjdk:11
COPY /target/invoice-1.0-SNAPSHOT.jar invoice.jar
#COPY --from=builder /invoice/target/invoice-1.0-SNAPSHOT.jar invoice.jar
EXPOSE 8081
CMD ["java", "-jar", "invoice.jar"]

