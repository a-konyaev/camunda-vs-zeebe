docker ps | grep camunda-app | awk '{print $1}' | xargs docker logs -f --tail 500
