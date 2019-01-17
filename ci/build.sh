#!/bin/sh

set -e -x

cd source-code || echo "missing input resource: source-code"

./mvnw clean package
