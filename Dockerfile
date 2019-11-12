FROM openjdk:8-jdk-alpine
ENV POSTGRESQL_URL=jdbc:postgresql://localhost:5533/gs_spring_boot_docker POSTGRESQL_USER=gs_spring_boot_docker POSTGRESQL_PASSOWORD=gs_spring_boot_docker
EXPOSE 8080
RUN mkdir -p /app/
ADD build/libs/gs-spring-boot-docker-0.1.0.jar /app/gs-spring-boot-docker-0.1.0.jar
ENTRYPOINT ["java", "-jar", "/app/gs-spring-boot-docker-0.1.0.jar"]