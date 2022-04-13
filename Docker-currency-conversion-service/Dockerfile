FROM maven:latest as builder
COPY currency-conversion-service /currency-conversion-service
RUN cd /currency-conversion-service && mvn package


#FROM openjdk:8-alpine
FROM openjdk:latest
#RUN apk --update add fontconfig ttf-dejavu
#RUN apk --no-cache add msttcorefonts-installer fontconfig && \
#update-ms-fonts && \
#fc-cache -f
COPY --from=builder /currency-conversion-service/target/currency-conversion-service.jar /opt/currency-conversion-service.jar
#ADD target/currency-exchange-service.jar currency-exchange-service.jar
EXPOSE 8000
#ENTRYPOINT [ "java", "-jar", "/opt/currency-exchange-service.jar"]
CMD ["java", "-jar", "/opt/currency-conversion-service.jar"]