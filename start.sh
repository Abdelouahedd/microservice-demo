#! /bin/bash
cd docker || exit
docker-compose -f app.yml up --build --remove-orphans
