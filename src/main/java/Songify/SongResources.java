package Songify;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SongResources {
    private SongDAOService service;

    public SongResources(SongDAOService service){
        this.service = service;
    }

    @GetMapping("/songs")
    public List<Song> getAllSongs(){
        return service.findAll();
    }

    @GetMapping("/songs/{id}")
    public Song getOneSong(@PathVariable int id){
        return service.findOne(id);
    }

    @GetMapping("/songs/artist/{id}")
    public List<String> getArtists(@PathVariable int id){
        return service.findOne(id).getArtists();
    }

    @PostMapping("/songs")
    public ResponseEntity<Song> createSong(@RequestBody Song song){
        service.createSong(song);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(song.getId()   ).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/songs/{id}")
    public void deleteSong(@PathVariable int id){
        service.deleteSong(id);
    }

    @PutMapping("/songs/{id}")
    public void replaceArtist(@PathVariable int id, @RequestBody List<String> artists){
        service.findOne(id).setArtists(artists);
    }
}
