package com.alexhennieroed.musikrlib.model;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an album
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
public class Album {

    private String name;
    private Artist artist;
    private List<Song> songs;

    /**
     * Creates a new album based on general album data
     * @param name the name of the album
     * @param artist the album's artist
     */
    public Album(String name, Artist artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    /**
     * Returns the name of the album
     * @return the name of the album
     */
    public String getName() { return name; }

    /**
     * Returns the album's artist
     * @return the album's artist
     */
    public Artist getArtist() { return artist; }

    /**
     * Returns the list of the album's songs
     * @return a list of the album's songs
     */
    public List<Song> getSongs() { return songs; }

    /**
     * Adds the given song to the list of songs
     * @param s the song to add
     * @throws InvalidParameterException if the song to add is null
     */
    public void addSong(Song s) throws InvalidParameterException {
        if (s != null) {
            songs.add(s);
        } else {
            throw new InvalidParameterException("The song given to add to the album's songs is null.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Album) {
            Album a = (Album) o;
            if (this.getName().equals(a.getName())
                    && this.getArtist().equals(a.getArtist())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 19 * getName().hashCode() * getArtist().hashCode() * getSongs().hashCode();
    }

}
