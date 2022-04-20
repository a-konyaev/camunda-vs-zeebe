#FILE=docker-compose.camunda.yml
FILE=docker-compose.zeebe.yml

cd ../ && ./gradlew clean build && cd local-start && docker-compose -f $FILE build
