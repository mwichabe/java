package SongsLinkedList;

import java.util.LinkedList;
import java.util.Collections;


class Song {

    String title;

    String artist;
    
    float duration;

    public Song(String title, String artist, float duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public float getDuration() {
        return duration;
    }
}

public class Main {

    public static void main(String[] args) {

        LinkedList<Song> playlist = new LinkedList<>();

        Song song1 = new Song("Shape of You", "Ed Sheeran", 4.23f);
        
        Song song2 = new Song("Blinding Lights", "The Weeknd", 3.20f);
        
        Song song3 = new Song("Someone Like You", "Adele", 4.45f);

        playlist.add(song1);

        playlist.add(song2);

        playlist.add(song3);

        // Add a song to the end of the list
        Song newSong = new Song("New Song", "New Artist", 3.30f);
        playlist.addLast(newSong);

        // Remove a song from the beginning of the list
        Song removedSong1 = playlist.pollFirst();
        if (removedSong1 != null) {
            System.out.println("Removed song from the beginning: " + removedSong1.getTitle());
        }

        // Remove a song from the end of the list
        Song removedSong2 = playlist.pollLast();
        if (removedSong2 != null) {
            System.out.println("Removed song from the end: " + removedSong2.getTitle());
        }

        // Shuffle the playlist
        Collections.shuffle(playlist);

        System.out.println("Suffled Playlist");
        
        for (Song song : playlist) {
            System.out.println(song.getTitle() + " by " + song.getArtist() + " (" + song.getDuration() + " minutes)");
        }

    }


}
