FROM maven:latest as builder
COPY currency-exchange-service /currency-exchange-service
RUN cd /currency-exchange-service && mvn package


#FROM openjdk:8-alpine
FROM openjdk:latest
#RUN apk --update add fontconfig ttf-dejavu
#RUN apk --no-cache add msttcorefonts-installer fontconfig && \
#update-ms-fonts && \
#fc-cache -f
COPY --from=builder /currency-exchange-service/target/currency-exchange-service.jar /opt/currency-exchange-service.jar
#ADD target/currency-exchange-service.jar currency-exchange-service.jar
EXPOSE 8000
#ENTRYPOINT [ "java", "-jar", "currency-exchange-service.jar"]
CMD ["java", "-jar", "/opt/currency-exchange-service.jar"]