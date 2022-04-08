FROM openjdk:8-jdk-alpine
COPY target/simple_shop-0.0.1-SNAPSHOT.jar /home/simple_shop-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD java $JAVA_OPTS -jar /home/simple_shop-0.0.1-SNAPSHOT.jar
