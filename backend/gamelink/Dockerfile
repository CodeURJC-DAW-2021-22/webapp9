#################################################
# Base image for the build container
#################################################
FROM maven:3.8.4-openjdk-17 as builder

# Defines the working directory where to execute commands
WORKDIR /project

# Copia las dependencias del proyecto
COPY pom.xml /project/

# Download the dependencies of the project (we have commented it so that they are downloaded from the internet, not locally)
#RUN mvn clean verify

# Copy the project code
COPY /src /project/src

# Compila proyecto
RUN mvn package -DskipTests=true

#################################################
# Base image for the application container
#################################################
FROM openjdk:17.0.2

# Defines the working directory where the JAR is located
WORKDIR /usr/src/app

# Copy the JAR from the build container
COPY --from=builder /project/target/*.jar /usr/src/app/

# Indicates the port that exposes the container
EXPOSE 8443

# Command that is executed when doing docker run
CMD [ "java", "-jar", "gamelink-0.0.1-SNAPSHOT.jar" ]

#################################################
# Base image for the application container
#################################################
