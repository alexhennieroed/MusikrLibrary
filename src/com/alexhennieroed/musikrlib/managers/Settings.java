package com.alexhennieroed.musikrlib.managers;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Contains the settings from the user
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
class Settings {

    private File settingsFile;

    private String musicDirectory;

    public Settings(String settingsFilePath)
            throws MissingSettingException {
        this.settingsFile = new File(settingsFilePath);
        parseSettings();
    }

    /**
     * Parses the settings file to initialize all necessary fields
     */
    private void parseSettings() throws MissingSettingException {
        try {
            Scanner scanner = new Scanner(settingsFile);
            //get the musicDirectory
            if (scanner.hasNextLine()) {
                musicDirectory = scanner.nextLine().split(":")[1];
            } else {
                throw new MissingSettingException("Music Source is missing.");
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Settings file was not found.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException a) {
            musicDirectory = "";
        }
    }

    /**
     * Saves the current settings to the settings file
     */
    private void saveSettings() {
        try {
            PrintStream stream = new PrintStream(settingsFile);
            stream.println("Music-Source:" + musicDirectory);
            stream.close();
        } catch (IOException e) {
            System.out.println("Settings file does not exist.");
        }
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
    public void setMusicDirectory(String musicDirectory) {
        this.musicDirectory = musicDirectory;
        saveSettings();
    }

}
