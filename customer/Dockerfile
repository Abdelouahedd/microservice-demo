FROM maven:3-openjdk-11  as builder
WORKDIR /customer
COPY pom.xml pom.xml
COPY src src
RUN mvn clean package

FROM openjdk:11
COPY --from=builder /customer/target/customer-1.0-SNAPSHOT.jar customer.jar
EXPOSE 8089
CMD ["java", "-jar", "customer.jar"]

