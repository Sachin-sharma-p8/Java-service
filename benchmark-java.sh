#!/bin/bash

# Usage: ./benchmark-java.sh <json_file> <concurrency> <requests>
JSON_FILE=${1:-../Typescript_project/data/test_data.json}
CONCURRENCY=${2:-10}
REQUESTS=${3:-1000}


HOST=localhost
PORT=9090

if [ ! -f "$JAVA_CLIENT_JAR" ]; then
  echo "Client JAR not found: $JAVA_CLIENT_JAR"
  echo "Please build the project with: ./mvnw clean package -DskipTests"
  exit 1
fi

echo "Running Java gRPC benchmark: $REQUESTS requests, $CONCURRENCY concurrency"
time java -cp $JAVA_CLIENT_JAR com.demo.project.GrpcDataProcessorClient --json $JSON_FILE --concurrency $CONCURRENCY --requests $REQUESTS --host $HOST --port $PORT 