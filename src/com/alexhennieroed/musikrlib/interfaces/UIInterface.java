package com.alexhennieroed.musikrlib.interfaces;

import com.alexhennieroed.musikrlib.model.Song;

import java.io.IOException;
import java.security.InvalidParameterException;

/**
 * Allows the library to work with any UI implementation
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
public interface UIInterface {

    /**
     * Selects the song to become the current song
     * @param song the song that was selected
     * @throws InvalidParameterException if selected song is null
     */
    void selectSong(Song song) throws InvalidParameterException;

    /**
     * Plays the current song
     * @throws IOException if there is an issue finding the current song
     */
    void play() throws IOException;

    /**
     * Pauses the playback of the current song
     */
    void pause();

    /**
     * Sets the next song as the current song and plays it
     * @throws IOException if there is a problem playing the new song
     */
    void next() throws IOException;

    /**
     * If the track has been playing for more than ten seconds,
     * the previous song is set as the current song and played.
     * Otherwise the current track is started from the beginning
     * @throws IOException if there is a problem playing the new song
     */
    void prev() throws IOException;

    /**
     * Toggles the shuffle feature
     */
    void shuffleToggle();

}
