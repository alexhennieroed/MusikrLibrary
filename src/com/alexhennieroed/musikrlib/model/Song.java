package com.alexhennieroed.musikrlib.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.InvalidParameterException;
import java.util.List;

/**
 * An object representing a song
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
public class Song {

    private String name;
    private Artist artist;
    private Album album;
    private List<Genre> genres;
    private Double duration;
    private File songFile;

    /**
     * Creates a new song based on general song data
     * @param name the name of the song
     * @param artist the song's artist
     * @param album the song's album
     */
    public Song(String name, Artist artist, Album album){
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.genres = null;
        this.duration = null;
        this.songFile = null;
    }

    /**
     * Returns the name of the song
     * @return the name of the song
     */
    public String getName() { return name; }

    /**
     * Returns the song's artist
     * @return the song's artist
     */
    public Artist getArtist() { return artist; }

    /**
     * Returns the song's album
     * @return the song's album
     */
    public Album getAlbum() { return album; }

    /**
     * Returns the song's genres if they are not null
     * @return the song's genres
     * @throws FileNotFoundException if the genres are null
     */
    public List<Genre> getGenres() throws FileNotFoundException {
        if (genres != null) {
            return genres;
        } else {
            throw new FileNotFoundException("The song " + name + " does not have genres associated with it.");
        }
    }

    /**
     * Returns the song's duration if it is not null
     * @return the song's duration
     * @throws FileNotFoundException if the duration is null
     */
    public Double getDuration() throws FileNotFoundException {
        if (duration != null) {
            return duration;
        } else {
            throw new FileNotFoundException("The song " + name + " does not have a duration associated with it.");
        }
    }

    /**
     * Returns the song's file if it is not null
     * @return the song's file
     * @throws FileNotFoundException if the file is null
     */
    public File getSongFile() throws FileNotFoundException {
        if (songFile != null) {
            return songFile;
        } else {
            throw new FileNotFoundException("The song " + name + " does not have a file associated with it.");
        }
    }

    /**
     * Sets the song's file to the specified one
     * @param songFile the song's new file
     * @throws InvalidParameterException if the new file is null
     */
    public void setSongFile(File songFile) throws InvalidParameterException {
        if (songFile != null) {
            this.songFile = songFile;
        } else {
            throw new InvalidParameterException("The file given as the song file is null.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Song) {
            Song s = (Song) o;
            if (this.getName().equals(s.getName())
                    && this.getArtist().equals(s.getArtist())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 17 * getName().hashCode() * getArtist().hashCode();
    }

}
