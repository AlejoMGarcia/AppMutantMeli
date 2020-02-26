#/bin/bash
./gradlew clean build
docker stop mutant-service
docker rm mutant-service
docker image rm mutant-service:latest
docker build --no-cache . -t mutant-service:latest
docker-compose up
