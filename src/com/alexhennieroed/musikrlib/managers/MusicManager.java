package com.alexhennieroed.musikrlib.managers;

import com.alexhennieroed.musikrlib.interfaces.UIInterface;
import com.alexhennieroed.musikrlib.model.Song;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidParameterException;

/**
 * Controls the current song and gives the data to the UI
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
class MusicManager implements UIInterface {

    private Song currentSong;
    private int currentSongIndex;
    private Song previousSong;
    private Song nextSong;
    private boolean shuffle;

    private MusicParser musicParser;
    private SongLoader songLoader;
    private PlaybackStyle style;
    private AudioStream audioStream;

    public MusicManager(MusicParser parser, SongLoader loader) {
        this.musicParser = parser;
        this.songLoader = loader;
        this.currentSong = musicParser.getSongList().get(0);
        this.currentSongIndex = 0;
    }

    @Override
    public void selectSong(Song song)
            throws InvalidParameterException {
        if (song != null) {
            this.currentSong = song;
        } else {
            throw new InvalidParameterException("The song selected is null.");
        }
    }

    @Override
    public void play() {
        try {
            File songFile = songLoader.loadSong(currentSong).getSongFile();
            audioStream = new AudioStream(new FileInputStream(songFile));
            AudioPlayer.player.start(audioStream);
        } catch (IOException e) {
            System.out.println("Could not find the song's file");
        }
    }

    @Override
    public void pause() {
        AudioPlayer.player.stop(audioStream);
    }

    @Override
    public void next() {
        currentSong = musicParser.getSongList().get(currentSongIndex + 1);
    }

    @Override
    public void prev() {
        if (currentSongIndex <= 0) {
            currentSongIndex = musicParser.getSongList().size();
        }
        currentSong = musicParser.getSongList().get(currentSongIndex - 1);
    }

    @Override
    public void shuffleOn() {
        this.shuffle = true;
    }

    @Override
    public void shuffleOff() {
        this.shuffle = false;
    }

    /**
     * Provides PlaybackStyles for the MusicManager
     */
    private enum PlaybackStyle {

        ALLSONGS(),
        BYARTIST(),
        BYALBUM(),
        ;

        PlaybackStyle() {}

    }

}
