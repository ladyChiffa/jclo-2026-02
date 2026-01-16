FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8080
ADD target/jclo-2026-02-0.0.1-SNAPSHOT.jar myapp.jar
ENTRYPOINT ["java","-jar","/myapp.jar"]

