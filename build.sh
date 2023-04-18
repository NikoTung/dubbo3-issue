#!/usr/bin/env bash

set -ex

mvn clean install
# shellcheck disable=SC2164
docker build -t example/provider -f service-provider/Dockerfile service-provider

docker build -t example/consumer -f consumer/Dockerfile consumer