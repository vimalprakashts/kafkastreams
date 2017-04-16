FROM openjdk:8-jre
COPY ./target/*-with-dependencies.jar /jars/service-jar.jar
CMD java -cp /jars/service-jar.jar test.kafkastream.Main