package com.alexhennieroed.musikrlib.managers;

import com.alexhennieroed.musikrlib.interfaces.UIInterface;
import com.alexhennieroed.musikrlib.model.Song;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.IOException;
import java.security.InvalidParameterException;

/**
 * Controls the current song and gives the data to the UI
 * @author Alexander Hennie-Roed
 * @version 1.0.1
 */
public class MusicManager implements UIInterface {

    private Song currentSong;
    private int currentSongIndex;
    private Song previousSong;
    private Song nextSong;
    private boolean shuffle;

    private MusicParser musicParser;
    private SongLoader songLoader;
    private PlaybackStyle style;
    private MediaPlayer player;

    /**
     * Creates a new MusicManager with the specified parser and loader
     * @param parser the MusicParser to use
     * @param loader the SongLoader to use
     */
    MusicManager(MusicParser parser, SongLoader loader) {
        this.musicParser = parser;
        this.songLoader = loader;
        this.shuffle = false;
        this.currentSong = musicParser.getSongList().get(0);
        this.currentSongIndex = 0;
        setPrevAndNextSong();
    }

    /**
     * Sets the previous and next song based on
     */
    private void setPrevAndNextSong() {
        //if (!shuffle) {
            if (currentSongIndex <= 0) {
                previousSong = musicParser.getSongList().get(
                        musicParser.getSongList().size() - 1);
            } else {
                previousSong = musicParser.getSongList().get(currentSongIndex - 1);
            }
            if (currentSongIndex >= musicParser.getSongList().size() - 1) {
                nextSong = musicParser.getSongList().get(0);
            } else {
                nextSong = musicParser.getSongList().get(currentSongIndex + 1);
            }
        //} else {
            //TODO
        //}
    }

    @Override
    public void selectSong(Song song)
            throws InvalidParameterException {
        if (song != null) {
            currentSong = songLoader.loadSong(song);
            currentSongIndex = musicParser.getSongList().indexOf(currentSong);
            setPrevAndNextSong();
        } else {
            throw new InvalidParameterException("The song selected is null.");
        }
    }

    @Override
    public void play() {
        try {
            String songFileLoc = songLoader.loadSong(currentSong).getSongLocation().toString();
            player = new MediaPlayer(new Media(songFileLoc));
            player.play();
        } catch (IOException e) {
            System.out.println("Could not find the song's file");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void pause() {
        player.pause();
    }

    @Override
    public void next() {
        currentSong = nextSong;
        currentSongIndex = musicParser.getSongList().indexOf(currentSong);
        setPrevAndNextSong();
        player.stop();
        play();
    }

    @Override
    public void prev() {
        if (player.getCurrentTime().toSeconds() > 10) {
            currentSong = previousSong;
            currentSongIndex = musicParser.getSongList().indexOf(currentSong);
            setPrevAndNextSong();
        }
        player.stop();
        play();
    }

    @Override
    public void shuffleToggle() {
        //Currently has no effect on functionality
        shuffle = !shuffle;
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
