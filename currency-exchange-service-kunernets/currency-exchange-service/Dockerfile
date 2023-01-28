FROM openjdk:17
ADD build/libs/*.jar currency-exchange-service.jar
EXPOSE 8000
RUN bash -c 'touch /currency-exchange.service.jar'
ENTRYPOINT ["java", "-jar", "currency-exchange-service.jar"]