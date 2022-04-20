#docker-compose down

docker rm -f camunda-app
docker rm -f scoring
docker rm -f storage
docker rm -f camunda-db
docker rm -f kafka
docker rm -f zookeeper
