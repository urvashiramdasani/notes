package IteratorDesignPattern;

public class Song {
    private String name;
    private String genre;
    private Integer duration;

    public Song(String name, String genre, Integer duration) {
        this.name = name;
        this.genre = genre;
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public String getName() {
        return name;
    }
}
