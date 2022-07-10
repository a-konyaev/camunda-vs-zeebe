# Camunda vs Zeebe

This is a demo project that attempts to compare Camunda 7 and 8 (Camunda Platform and Zeebe)
in terms of functionality as well as performance.

### Prerequisites

- Java 17

### Building and running locally
```bash
./gradlew clean build
java -jar camunda-app/build/libs/camunda-app.jar
```

### Running inside docker

- go to dir ./local-start
- setup needed environment
    ```bash
    source set_camunda.sh
    ```
    You can also choose one of set_*.sh files.
- start docker containers:
    ```bash
    ./up.sh
    ```
