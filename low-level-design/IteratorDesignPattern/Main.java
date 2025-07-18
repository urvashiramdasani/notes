package IteratorDesignPattern;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.addSong(new Song("Paradise", "Pop", 120));
        playlist.addSong(new Song("Intentions", "Pop", 140));
        playlist.addSong(new Song("Alibi", "Rock", 100));

        Iterator iterator = playlist.createIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next().getName());
        }

        Iterator genreIterator = playlist.createGenreIterator("Pop");
        while(genreIterator.hasNext()) {
            System.out.println(genreIterator.next().getName());
        }
    }
}
