package com.alexhennieroed.musikrlib.interfaces;

import com.alexhennieroed.musikrlib.model.Song;

import java.util.List;

/**
 * Gets the important data from a song file using any library desired
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
public interface SongDataInterface {

    /**
     * Gets the metadata for the song in the order of
     * Name, Artist, Album, Genre, Duration
     * @param s
     * @return
     */
    List<String> getData(Song s);

}
