#!/bin/bash

docker build -t juanurjc/gamelink .

docker push juanurjc/gamelink

docker pull juanurjc/gamelink:latest