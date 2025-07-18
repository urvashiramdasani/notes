package IteratorDesignPattern;

import java.util.List;

public class SongIterator implements Iterator {
    int index = 0;
    List<Song> songs;

    public SongIterator(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public boolean hasNext() {
        return index < songs.size();
    }

    @Override
    public Song next() {
        return this.songs.get(index++);
    }
}
