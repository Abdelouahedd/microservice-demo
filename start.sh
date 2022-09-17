#! /bin/bash
#mvn clean compile
mvn clean -DskipTests package


cd docker || exit
docker-compose -f app.yml up --build --remove-orphans
