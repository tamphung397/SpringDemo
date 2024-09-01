FROM eclipse-temurin:17-jdk-alpine
EXPOSE 8989
ADD target/CutomAnnotationSpringboot-0.0.1-SNAPSHOT.jar CutomAnnotationSpringboot-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/CutomAnnotationSpringboot-0.0.1-SNAPSHOT.jar"]