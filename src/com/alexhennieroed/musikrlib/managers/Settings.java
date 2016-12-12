package com.alexhennieroed.musikrlib.managers;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

/**
 * Contains the settings from the user
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
 public class Settings {

    private File settingsFile;

    private String musicDirectory;

    Settings(URL settingsFile)
            throws MissingSettingException, IOException {
        this.settingsFile = new File(settingsFile.getPath());
        parseSettings();
    }

    /**
     * Parses the settings file to initialize all necessary fields
     */
    private void parseSettings()
            throws MissingSettingException, IOException {
        try {
            Scanner scanner = new Scanner(settingsFile);
            //get the musicDirectory
            if (scanner.hasNextLine()) {
                musicDirectory = scanner.nextLine().split(":")[1];
            } else {
                throw new MissingSettingException("Music Source is missing.");
            }
            scanner.close();
        } catch (ArrayIndexOutOfBoundsException a) {
            musicDirectory = "";
        }
    }

    /**
     * Saves the current settings to the settings file
     */
    private void saveSettings() throws IOException {
        PrintStream stream = new PrintStream(settingsFile);
        stream.println("Music-Source:" + musicDirectory);
        stream.close();
    }

    /**
     * Returns the music directory
     * @return the music directory
     */
    public String getMusicDirectory() { return musicDirectory; }

    /**
     * Sets the music directory to the new directory
     * @param musicDirectory the new music directory
     */
    public void setMusicDirectory(String musicDirectory)
        throws IOException {
        this.musicDirectory = musicDirectory;
        saveSettings();
    }

}
