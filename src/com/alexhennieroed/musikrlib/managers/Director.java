package com.alexhennieroed.musikrlib.managers;

import com.alexhennieroed.musikrlib.interfaces.MusicInterface;
import javafx.scene.control.Alert;

import java.security.InvalidParameterException;

/**
 * Controls the entire app
 * Singleton
 *
 * When using it, the MusicInterface must be set before getting the instance
 *      of the MusicParser otherwise a NullPointerException will be thrown
 *
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
public class Director {

    /**
     * Singleton instance
     */
    private static Director director = new Director();

    /**
     * Instances of required managers and interfaces
     */
    private static MusicManager musicManager;
    private static MusicParser musicParser;
    private static SongLoader songLoader;
    private static MusicInterface musicInterface;
    private static JaudioConnector connector;
    private static Settings settings;

    /**
     * Private constructor of the singleton Director
     */
    private Director() {
        try {
            settings = new Settings("/com/alexhennieroed/musikrlib/settings.txt");
        } catch (MissingSettingException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("There Has Been an Issue with the Settings File");
            alert.setHeaderText("");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    /**
     * Returns the instance of the Director
     * @return the instance
     */
    public static Director getInstance() { return director; }

    /**
     * Returns the Director's MusicInterface
     * @return the MusicInterface
     * @throws NullPointerException if the current MusicInterface is null
     */
    public static MusicInterface getMusicInterface() throws NullPointerException {
        if (musicInterface != null) {
            return musicInterface;
        } else {
            throw new NullPointerException("The current music interface is null.");
        }
    }

    /**
     * Sets the Director's MusicInterface
     * @param mi the new MusicInterface
     * @throws InvalidParameterException if the new MusicInterface is null
     */
    public static void setMusicInterface(MusicInterface mi)
            throws InvalidParameterException {
        if (mi != null) {
            musicInterface = mi;
            musicParser = new MusicParser(musicInterface);
            songLoader = new SongLoader(musicInterface);
            musicManager = new MusicManager(musicParser, songLoader);
        } else {
            throw new InvalidParameterException("The MusicInterface given is null.");
        }
    }

}
