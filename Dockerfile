FROM openjdk:17-jdk
EXPOSE 8404
ADD target/kuryeraze-0.0.1-SNAPSHOT.jar kuryeraze.jar
HEALTHCHECK --interval=30s --timeout=10s --retries=3 \
  CMD curl --fail http://localhost:8404/ || exit 1
ENTRYPOINT ["java", "-jar", "kuryeraze.jar"]
