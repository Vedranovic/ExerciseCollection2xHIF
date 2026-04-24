package at.htlkaindorf.exa_407_musicapp.controller;

import at.htlkaindorf.exa_407_musicapp.pojos.Interpret;
import at.htlkaindorf.exa_407_musicapp.pojos.Song;

import java.util.Arrays;
import java.util.Comparator;

public class SongController {
    private Song[] songs;
    private int numOfSongs;

    public SongController() {
        this.songs = new Song[10];
        this.numOfSongs = 0;
    }

    private void sortSongs() {
        Arrays.sort(songs, Comparator.nullsLast(Comparator.comparingDouble(Song::getLength)));
    }

    public void addSong(Song song) throws Exception {
        if (numOfSongs > 9) {
            throw new Exception("No more songs can be added!");
        }

        songs[numOfSongs] = song;
        sortSongs();
        numOfSongs++;
    }

    public void addSong(Song song, String interpretName) throws Exception {
        if (numOfSongs > 9) {
            throw new Exception("No more songs can be added!");
        }

        Interpret interpret = new Interpret(interpretName);
        song.clearInterprets();
        song.addingInterpret(interpret);
        songs[numOfSongs] = song;
        numOfSongs++;
        sortSongs();
    }

    public Song[] getSongs() {
        return songs;
    }

    public int getNumOfSongs() {
        return numOfSongs;
    }
}
