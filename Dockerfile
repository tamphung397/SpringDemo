FROM openjdk:8
EXPOSE 8080
ADD target/CutomAnnotationSpringboot-0.0.1-SNAPSHOT.jar CutomAnnotationSpringboot-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/CutomAnnotationSpringboot-0.0.1-SNAPSHOT.jar"]