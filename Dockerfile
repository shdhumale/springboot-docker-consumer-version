From openjdk:11
copy ./target/springboot-docker-consumer-version-0.0.1-SNAPSHOT.jar springboot-docker-consumer-version-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","springboot-docker-consumer-version-0.0.1-SNAPSHOT.jar"]