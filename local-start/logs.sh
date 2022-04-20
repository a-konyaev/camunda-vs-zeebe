#APP=camunda-app
APP=zeebe-app

docker ps | grep $APP | awk '{print $1}' | xargs docker logs -f --tail 500
