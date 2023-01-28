FROM openjdk:17
ADD build/libs/*.jar currency-conversion-service.jar
EXPOSE 8100
RUN bash -c 'touch /currency-conversion.service.jar'
ENTRYPOINT ["java", "-jar", "currency-conversion-service.jar"]