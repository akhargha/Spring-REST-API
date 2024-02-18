package Songify;

import java.util.List;

public class Song {
    private int id;
    private String name;
    private List<String> artists;

    public Song(int id, String name, List<String> artists) {
        this.id = id;
        this.name = name;
        this.artists = artists;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getArtists() {
        return artists;
    }

    public void setArtists(List<String> artists) {
        this.artists = artists;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artists=" + artists +
                ", count=" + id +
                '}';
    }
}
