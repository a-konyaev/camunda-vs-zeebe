FROM bellsoft/liberica-openjre-alpine:17

ARG APP="zeebe-app"

WORKDIR /opt/app
COPY ./build/libs/$APP.jar .

ENV MALLOC_ARENA_MAX="4" \
    APP="$APP" \
    MAIN_CLASS="$MAIN_CLASS" \
    JAVA_OPTS="\
      -XX:+AlwaysActAsServerClassMachine \
      -XX:+UseParallelGC \
      -XX:ActiveProcessorCount=2 \
      -Xms1000m \
      -Xmx1000m \
    "

EXPOSE 8080

ENTRYPOINT ["/bin/sh", "-c", "set -x && java $JAVA_OPTS -jar /opt/app/$APP.jar"]
