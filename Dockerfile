FROM openjdk:latest
ADD build/libs/postgres-demo-v1.jar postgres-demo-v1.jar
ENTRYPOINT ["java","-jar","postgres-demo-v1.jar"]
