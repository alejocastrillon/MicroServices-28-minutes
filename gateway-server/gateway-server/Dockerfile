FROM openjdk:17
ADD build/libs/*.jar gateway.jar
EXPOSE 8765
RUN bash -c 'touch /gateway.jar'
ENTRYPOINT ["java", "-jar", "gateway.jar"]