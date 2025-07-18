package IteratorDesignPattern;

import java.util.List;

public class GenreIterator implements Iterator {
    private final List<Song> songs;
    private final String genre;
    private int position = 0;

    public GenreIterator(List<Song> songs, String genre) {
        this.songs = songs;
        this.genre = genre;
    }

    private void moveToNextValid() {
        while (position < songs.size() && !songs.get(position).getGenre().equalsIgnoreCase(genre)) {
            position++;
        }
    }

    @Override
    public boolean hasNext() {
        return position < songs.size();
    }

    @Override
    public Song next() {
        Song song = songs.get(position++);
        moveToNextValid();
        return song;
    }
}
