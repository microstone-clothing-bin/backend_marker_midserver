# Base image: Java 21 (필요하면 17로 바꿔도 됨)
FROM eclipse-temurin:21-jdk-jammy

# /tmp 폴더를 위한 볼륨 세팅 (Spring boot)
VOLUME /tmp

# 빌드된 jar 파일을 컨테이너에 복사
COPY build/libs/clothing-midserver-0.0.1-SNAPSHOT.jar app.jar

# 컨테이너 시작할 때 실행할 명령어
ENTRYPOINT ["java", "-jar", "/app.jar"]