#FROM maven:3-openjdk-11 as builder
#WORKDIR /gateway
#COPY pom.xml pom.xml
#COPY src src
#RUN mvn compile
#RUN mvn package


FROM openjdk:11
#COPY --from=builder /gateway/target/gateway-1.0-SNAPSHOT.jar gateway.jar
COPY /target/gateway-1.0-SNAPSHOT.jar gateway.jar
EXPOSE 9000
CMD ["java", "-jar", "gateway.jar"]

