package com.alexhennieroed.musikrlib.interfaces;

import com.alexhennieroed.musikrlib.model.Song;

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
     */
    void play();

    /**
     * Pauses the playback of the current song
     */
    void pause();

    /**
     * Sets the next song as the current song and plays it
     */
    void next();

    /**
     * The previous song is set as the current song and played
     */
    void prev();

    /**
     * Turns on the shuffle feature
     */
    void shuffleOn();

    /**
     * Turns off the shuffle feature
     */
    void shuffleOff();

}
