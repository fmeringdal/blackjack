# Blackjack

## Compile and execute
```
mvn clean compile exec:java
// or by getting deck from file
mvn clean compile exec:java -Dexec.args="FULL_PATH_TO_FILE"
```

## Run tests
A code coverage report will also be generated in *target/site/jacoco/index.html*
```
mvn clean test
```