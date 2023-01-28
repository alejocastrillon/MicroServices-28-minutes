FROM openjdk:17
ADD build/libs/*.jar naming-server.jar
EXPOSE 8761
RUN bash -c 'touch /naming-server.jar'
ENTRYPOINT ["java", "-jar", "naming-server.jar"]