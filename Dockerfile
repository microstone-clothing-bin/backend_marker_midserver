FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

# Gradle wrapper 및 소스 전체 복사
COPY . .

# gradle 빌드 실행 (jar 파일 생성)
RUN ./gradlew clean build

# 빌드 산출물 경로에서 jar 복사
RUN cp build/libs/clothing-midserver-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
