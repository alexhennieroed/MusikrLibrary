package com.alexhennieroed.musikrlib.interfaces;

import com.alexhennieroed.musikrlib.model.Song;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Gets the important data from a song file using any library desired
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
public interface SongDataInterface {

    /**
     * Gets the metadata for the song in the order of
     * Name, Artist, Album, Genre, Duration
     * @param s the song to get the data of
     * @return the song data in a list
     * @throws Exception if there is an error with handling the file
     */
    List<String> getData(Song s) throws Exception;

}
