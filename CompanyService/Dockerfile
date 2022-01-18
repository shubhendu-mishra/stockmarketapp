FROM openjdk:11
WORKDIR /usr/src
ENV MONGODB_USER = shubhendu
ENV MONGODB_PASSWORD = Market%403542%21
ADD ./target/company-0.0.1-SNAPSHOT.jar /usr/src/company-0.0.1-SNAPSHOT.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-jar","company-0.0.1-SNAPSHOT.jar"]