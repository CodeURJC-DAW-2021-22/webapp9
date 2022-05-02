#!/bin/bash

cd ../../frontend
npm install
ng build --base-href="/new/"

cp dist/frontend/* ../backend/gamelink/src/main/resources/static/new

cd ../backend/gamelink

docker build -t juanurjc/gamelink .

docker push juanurjc/gamelink

docker pull juanurjc/gamelink:latest