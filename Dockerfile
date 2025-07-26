# 1단계: 빌드용 이미지 (Gradle + JDK)
FROM gradle:8.3.1-jdk21 AS build

WORKDIR /app

# gradle 캐시를 이용하기 위해 의존성 파일 먼저 복사
COPY build.gradle settings.gradle gradle.properties* ./
COPY gradle ./gradle

# 의존성 캐싱을 위해 먼저 다운로드 (빌드 속도 향상)
RUN gradle --no-daemon clean build -x test || true

# 소스 전체 복사
COPY . .

# 실제 빌드 (테스트 제외)
RUN gradle --no-daemon bootJar -x test

# 2단계: 런타임용 이미지
FROM eclipse-temurin:21-jdk-jammy

VOLUME /tmp

# 1단계에서 빌드된 jar 파일 복사
COPY --from=build /app/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
