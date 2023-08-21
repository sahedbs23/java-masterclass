package dev.sahedmoral.linklist.playlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String songTitle, double duration) {
        return this.songs.add(new Song(songTitle,duration));
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        Song checkedSong = this.songs.findSong(trackNumber);
        if(checkedSong != null) {
            playlist.add(checkedSong);
            return true;
        }
        return false;
    }

    public boolean addToPlayList(String songTitle, LinkedList<Song> playlist) {
        Song checkedSong = this.songs.findSong(songTitle);
        if(checkedSong != null) {
            playlist.add(checkedSong);
            return true;
        }
        return false;
    }

    public static class SongList {
        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<Song>();
        }

        private boolean add(Song song) {
            if(songs.contains(song)) {
                return false;
            }
            this.songs.add(song);
            return true;
        }

        private Song findSong(String songTitle) {
            for(Song checkingSong: this.songs){
                if(checkingSong.getTitle().equals(songTitle)) {
                    return checkingSong;
                }
            }
            return null;
        }

        private Song findSong(int trackNumber) {
            int index = trackNumber -1;
            if((index > 0) && (index<songs.size())) {
                return songs.get(index);
            }
            return null;
        }

    }

}
