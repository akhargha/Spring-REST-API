package Songify;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SongDAOService {
    private static List<Song> songs = new ArrayList<>();
    private static int count = 0;

    static{
        songs.add(new Song(++count, "Song1", Arrays.asList("John", "Marty")));
        songs.add(new Song(++count, "Song2", Arrays.asList("Max")));
        songs.add(new Song(++count, "Song3", Arrays.asList("John", "Marty", "Mary")));
    }

    public List<Song> findAll(){
        return songs;
    }

    public Song findOne(int id){
        for (int i = 0; i < songs.size(); i++){
            if (songs.get(i).getId() == id){
                return songs.get(i);
            }
        }
        throw new SongNotFoundException("Song ID: " + id);
    }

    public Song createSong(Song song){
        song.setId(++count);
        songs.add(song);
        return song;
    }

    public void deleteSong(int id){
        for (int i = 0; i < songs.size(); i++){
            if (songs.get(i).getId() == id){
                songs.remove(songs.get(i));
            }
        }
    }
}
