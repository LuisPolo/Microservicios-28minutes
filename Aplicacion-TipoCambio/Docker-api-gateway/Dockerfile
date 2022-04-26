FROM maven:latest as builder
COPY api-gateway /api-gateway
RUN cd /api-gateway && mvn package


#FROM openjdk:8-alpine
FROM openjdk:latest
#RUN apk --update add fontconfig ttf-dejavu
#RUN apk --no-cache add msttcorefonts-installer fontconfig && \
#update-ms-fonts && \
#fc-cache -f
COPY --from=builder /api-gateway/target/api-gateway.jar /opt/api-gateway.jar
#ADD target/currency-exchange-service.jar currency-exchange-service.jar
EXPOSE 8000
#ENTRYPOINT [ "java", "-jar", "/opt/currency-exchange-service.jar"]
CMD ["java", "-jar", "/opt/api-gateway.jar"]