package IteratorDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private final List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        songs.add(song);
    }

    public Iterator createIterator() {
        return new SongIterator(songs);
    }

    public Iterator createGenreIterator(String genre) {
        return new GenreIterator(songs, genre);
    }
}
