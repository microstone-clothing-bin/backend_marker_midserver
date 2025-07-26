# Base image: Java 21 (17로 변경해야 할 수도 있음)
FROM eclipse-temurin:21-jdk-jammy

# /tmp 폴더를 위한 볼륨 세팅 (Spring boot)
VOLUME /tmp

# 빌드된 jar 파일을 컨테이너에 복사
COPY build/libs/*.jar app.jar

# 컨테이너 시작할 때 실행할 명령어
ENTRYPOINT ["java", "-jar", "/app.jar"]