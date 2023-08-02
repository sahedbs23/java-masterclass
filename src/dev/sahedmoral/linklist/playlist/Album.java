package dev.sahedmoral.linklist.playlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist){
        this.name = name;
        this.artist =artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration){
        Song song = findSong(title);
        if (song != null){
            return false;
        }

        return this.songs.add(new Song(title,duration));
    }

    private Song findSong(String title){
        for (Song song : this.songs) {
            if (Objects.equals(song.getTitle(), title)) {
                return song;
            }
        }
        return null;
    }

    public boolean addToPlayList(int track, LinkedList<Song> songLinkedList){
        if (track<0 || track > this.songs.size()-1){
            return false;
        }
            Song song = this.songs.get(track);
        int indexOf = songLinkedList.indexOf(song);
        if (indexOf >= 0){
            return true;
        }
        return songLinkedList.add(song);
    }

    public boolean addToPlayList(String title, LinkedList<Song> songLinkedList){
        Song song = this.findSong(title);
        if (song == null){
            return false;
        }
        int indexOf = songLinkedList.indexOf(song);
        if (indexOf >= 0){
            return true;
        }
        return songLinkedList.add(song);
    }
}
