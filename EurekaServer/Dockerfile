#FROM maven:3-openjdk-11  as builder
#WORKDIR /eureka-server
#COPY pom.xml pom.xml
#COPY src src
#RUN mvn compile
#RUN mvn package



FROM openjdk:11
#COPY --from=builder /eureka-server/target/eureka-server-1.0-SNAPSHOT.jar eureka-server.jar
COPY  /target/eureka-server-1.0-SNAPSHOT.jar eureka-server.jar 
EXPOSE 8761
CMD ["java", "-jar", "eureka-server.jar"]

