#!/bin/bash

max=$1
if [ -z $max ]; then
    echo "Usage: test.sh <requests-count>"
    exit 1
fi

echo "Running test for $max requests..."
i=0
startTime=`date +%s`

while [ $i -lt $max ]; do
  echo $i
  curl -s -X 'POST' \
    'http://localhost:8080/process/start' \
    -H 'accept: text/plain' \
    -H 'Content-Type: application/json' \
    -d "{\"applicationId\": \"app-$i-`uuidgen`\"}" > /dev/null
  ((i++))
done

echo -e "\nConsuming responses..."
kafka-console-consumer \
  --bootstrap-server localhost:9093 \
  --topic company-scoring-response \
  --group test \
  --max-messages $max

endTime=`date +%s`
elapsedTime=$(echo "$endTime - $startTime" | bc -l)
echo -e "\nTest finished in $elapsedTime sec"
