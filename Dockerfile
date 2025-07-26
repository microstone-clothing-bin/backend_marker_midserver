FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY . .

# 실행 권한 부여
RUN chmod +x ./gradlew

RUN ./gradlew clean build

RUN cp build/libs/clothing-midserver-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]