FROM openjdk:11
WORKDIR /usr/src
ENV MONGODB_USER = shubhendu
ENV MONGODB_PASSWORD = Service%403542%21
ADD ./target/stock-0.0.1-SNAPSHOT.jar /usr/src/stock-0.0.1-SNAPSHOT.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-jar","stock-0.0.1-SNAPSHOT.jar"]