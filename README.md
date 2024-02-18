# Spring-boot REST API with Docker
In this project, I created a REST API using SpringBoot and containarized it using Docker.

## How to run the application?
1. Build the Docker image-
```
docker build -t <your-image-name> .
````
2. Run the Docker container-
```
docker run -p 8080:8080 <your-image-name>
```

## Swagger Documentation

To look at the swagger documentation, run-
```
http://localhost:8080/swagger-ui/index.html#/
```



