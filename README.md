# Spring-boot REST API with Docker
This project demonstrates the creation of a REST API using Spring Boot, which is then containerized using Docker. The API is designed to manage a simple song database, allowing operations such as adding, retrieving, updating, and deleting song entries.

## API Usage

The REST API supports the following operations:

1. GET /songs: Retrieve a list of all songs.
2. GET /songs/{id}: Retrieve a specific song by its ID.
3. GET /songs/artist/{id}: Retrieve the artists of a specific song by the song's ID.
4. POST /songs: Add a new song.
5. PUT /songs/{id}: Update the artist list of a specific song.
6. DELETE /songs/{id}: Delete a specific song.

## How to run the application?
1. Build the Docker image-
```
docker build -t <your-image-name> .
````
2. Run the Docker container-
```
docker run -p 8080:8080 <your-image-name>
```

## Updated build instructions for W8:
```
docker build -t yourusername/microservice-name:latest .
```

```
docker push yourusername/microservice-name:latest
```

```
kubectl apply -f configmap.yaml
kubectl apply -f deployment.yaml
kubectl apply -f nodeport.yaml
```

```
kubectl get deployments
kubectl get pods
kubectl get service
kubectl get ConfigMap 
```

```
curl "http://localhost:31234/fib?length=4"
curl "http://localhost:31234/config"
```

## Swagger Documentation

To look at the swagger documentation, run-
```
http://localhost:8080/swagger-ui/index.html#/
```

## Learning Journey:
I already knew quite a bit of Spring Boot from Prof. Ken Kousen's class last semester, so building a REST API was not super tricky for me. I did have to read some documentation and watch some tutorials to refresh my memory, but it was fairly simple. I spent some time going over the docker image and tried to understand its function. I used ChatGPT for some documentation and help in understanding Docker.


