FROM openjdk:17
EXPOSE 8989
COPY ./target/CutomAnnotationSpringboot-0.0.1-SNAPSHOT.jar CutomAnnotationSpringboot-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/CutomAnnotationSpringboot-0.0.1-SNAPSHOT.jar"]