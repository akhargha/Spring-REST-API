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

## Swagger Documentation

To look at the swagger documentation, run-
```
http://localhost:8080/swagger-ui/index.html#/
```



