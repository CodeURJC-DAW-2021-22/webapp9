#!/bin/bash

mvn spring-boot:build-image -Dspring-boot.build-image.imageName=registry.heroku.com/codeurjc-daw-2021-22-webapp9/web

docker push registry.heroku.com/codeurjc-daw-2021-22-webapp9/web

heroku container:release web -a codeurjc-daw-2021-22-webapp9

heroku logs --tail -a codeurjc-daw-2021-22-webapp9