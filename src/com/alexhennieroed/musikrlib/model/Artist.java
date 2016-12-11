package com.alexhennieroed.musikrlib.model;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents and artist
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
public class Artist {

    private String name;
    private List<Album> albums;

    /**
     * Creates a new artist based on a name
     * @param name the artist's name
     */
    public Artist(String name) {
        this.name = name;
        this.albums = new ArrayList<>();
    }

    /**
     * Returns the name of the artist
     * @return the name of the artist
     */
    public String getName() { return name; }

    /**
     * Returns the artist's albums
     * @return the list of the artist's albums
     */
    public List<Album> getAlbums() { return albums; }

    /**
     * Adds the given album to the artist's list of albums
     * @param a the album to add
     * @throws InvalidParameterException if the album to add is null
     */
    public void addAlbum(Album a) throws InvalidParameterException {
        if (a != null) {
            albums.add(a);
        } else {
            throw new InvalidParameterException("The album to add to the artist is null.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Artist) {
            Artist a = (Artist) o;
            if (this.getName().equals(a.getName())
                    && this.getAlbums().equals(a.getAlbums())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 23 * getName().hashCode() * getAlbums().hashCode();
    }

}
