FROM openjdk:11
COPY target/eventsubscriber-0.0.1.jar eventsubscriber-0.0.1.jar
EXPOSE 8082
EXPOSE 5672
ENTRYPOINT ["java","-jar","/eventsubscriber-0.0.1.jar"]
