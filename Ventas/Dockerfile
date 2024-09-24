FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/Ventas-0.0.1.jar
COPY ${JAR_FILE} app_ventas.jar
ENTRYPOINT ["java","-jar","app_ventas.jar"]
