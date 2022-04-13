FROM maven:latest as builder
COPY naming-server /naming-server
RUN cd /naming-server && mvn package

#FROM openjdk:8-alpine
FROM openjdk:latest
#RUN apk --update add fontconfig ttf-dejavu
#RUN apk --no-cache add msttcorefonts-installer fontconfig && \
#update-ms-fonts && \
#fc-cache -f
COPY --from=builder /naming-server/target/naming-server.jar /opt/naming-server.jar
#ADD target/naming-server.jar naming-server.jar
EXPOSE 8761
#ENTRYPOINT [ "java", "-jar", "currency-exchange-service.jar"]
CMD ["java", "-jar", "/opt/naming-server.jar"]