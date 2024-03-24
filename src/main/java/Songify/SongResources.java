package Songify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;

@RestController
public class SongResources {
    private final SongDAOService service;
    private final Environment environment;

    @Autowired
    public SongResources(SongDAOService service, Environment environment) {
        this.service = service;
        this.environment = environment;
    }

    @GetMapping("/songs")
    public List<Song> getAllSongs() {
        return service.findAll();
    }

    @GetMapping("/songs/{id}")
    public Song getOneSong(@PathVariable int id) {
        return service.findOne(id);
    }

    @GetMapping("/songs/artist/{id}")
    public List<String> getArtists(@PathVariable int id) {
        return service.findOne(id).getArtists();
    }

    @PostMapping("/songs")
    public ResponseEntity<Object> createSong(@RequestBody Song song) {
        Song savedSong = service.createSong(song);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedSong.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/songs/{id}")
    public void deleteSong(@PathVariable int id) {
        service.deleteSong(id);
    }

    @PutMapping("/songs/{id}")
    public void replaceArtist(@PathVariable int id, @RequestBody List<String> artists) {
        service.findOne(id).setArtists(artists);
    }

    @GetMapping("/config")
    public ResponseEntity<Map<String, String>> getConfig() {
        Map<String, String> envVars = new HashMap<>();
        Map<String, String> properties = System.getenv();
        StringBuilder logOutput = new StringBuilder("Environment Variables:\n");
        properties.forEach((key, value) -> {
            envVars.put(key, String.valueOf(value));
            logOutput.append(key).append("=").append(value).append("\n"); // Prepare log message
        });

        // Log to the console
        System.out.println(logOutput);

        return ResponseEntity.ok(envVars);
    }

    @GetMapping("/fib")
    public List<Integer> getFibonacciSequence(@RequestParam int length) {
        List<Integer> fibSequence = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (i == 0) fibSequence.add(0);
            else if (i == 1) fibSequence.add(1);
            else fibSequence.add(fibSequence.get(i - 1) + fibSequence.get(i - 2));
        }
        return fibSequence;
    }
}
