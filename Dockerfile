FROM openjdk:17
EXPOSE 9003
LABEL maintainer="RupSTLer"          
ADD target/student-microservice.jar student-microservice.jar
ENTRYPOINT ["java", "-jar", "student-microservice.jar"]