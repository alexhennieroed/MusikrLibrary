package com.alexhennieroed.musikrlib.interfaces;

import com.alexhennieroed.musikrlib.model.Album;
import com.alexhennieroed.musikrlib.model.Artist;
import com.alexhennieroed.musikrlib.model.Song;

import java.util.List;

/**
 * Allows connection to multiple types of music providers
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
public interface MusicInterface {

    /**
     * Returns the song from the provider based on data in the song parameter
     * @param s basic info about the song
     * @return the song from the provider
     */
    Song getSong(Song s);

    /**
     * Finds all of the artists in the provider's database
     * @return the list of artists
     */
    List<Artist> getArtists();

    /**
     * Finds all of the albums in the provider's database
     * @return the list of all albums
     */
    List<Album> getAlbums();

    /**
     * Finds all of the songs in the provider's database
     * @return the list of all songs
     */
    List<Song> getSongs();

}
