#!/bin/bash

cd ../../frontend

npm install

ng build --base-href="/new/"

cp -r dist/frontend/* ../backend/gamelink/src/main/resources/static/new

cd ../backend/gamelink

docker build -t gamelink_web .

docker push gamelink_web

docker pull gamelink_web:latest