#Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

#Information around who maintains the images
MAINTAINER sagensoren.com

#Add the application's jar to the container
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

#Execute the application
ENTRYPOINT ["java","-jar","/accounts-0.0.1-SNAPSHOT.jar"]



#FROM openjdk:8-jdk-alpine
 #ARG JAR_FILE=target/*.jar
 #COPY ${JAR_FILE} app.jar
 #ENTRYPOINT [ "java", "-jar",  "/app.jar"]
