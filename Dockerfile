FROM openjdk:8

# <--------Build & Run-------->
# docker build --no-cache . -t mutant-service:latest -t mutant-service:VX.XX.XX
# <--------Build & Run-------->

MAINTAINER "ale.garciaa210@gmail.com"

WORKDIR /api
COPY ["build/libs","/api/"]
CMD java -jar -server -Xmx512m -XX:+UseG1GC mutant-service-1.0.0-SNAPSHOT.jar