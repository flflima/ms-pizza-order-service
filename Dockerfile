FROM adoptopenjdk:11.0.6_10-jre-openj9-0.18.1

WORKDIR /app

EXPOSE 8080

COPY ./build/libs/ms-pizza-order-service-0.1-all.jar ./app.jar

CMD java -jar app.jar