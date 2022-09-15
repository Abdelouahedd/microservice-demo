#! /bin/bash
mvn clean compile
mvn package
mvn install

cd docker || exit
docker-compose -f app.yml up --build --remove-orphans
