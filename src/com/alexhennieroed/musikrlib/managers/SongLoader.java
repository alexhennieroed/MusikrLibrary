package com.alexhennieroed.musikrlib.managers;

import com.alexhennieroed.musikrlib.interfaces.MusicInterface;
import com.alexhennieroed.musikrlib.model.Song;

import java.security.InvalidParameterException;

/**
 * Loads songs
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
class SongLoader {

    private MusicInterface musicInterface;

    public SongLoader(MusicInterface mi) {
        this.musicInterface = mi;
    }

    /**
     * Loads the specified song from the provider
     * @param s the song to load
     * @return the loaded song
     */
    public Song loadSong(Song s) throws InvalidParameterException {
        if (s != null) {
            return musicInterface.getSong(s);
        } else {
            throw new InvalidParameterException("The song to load cannot be null.");
        }
    }

}
