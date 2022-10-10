FROM openjdk:18-jdk-alpine

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]

#ENTRYPOINT ["java","-jar","/message-server-1.0.0.jar"]