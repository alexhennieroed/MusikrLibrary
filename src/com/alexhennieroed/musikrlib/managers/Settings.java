package com.alexhennieroed.musikrlib.managers;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Contains the settings from the user
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
class Settings {

    private File settingsFile;

    public Settings(String settingsFilePath) {
        this.settingsFile = new File(settingsFilePath);
        parseSettings();
    }

    /**
     * Parses the settings file to initialize all necessary fields
     */
    private void parseSettings() {
        try {
            Scanner scanner = new Scanner(settingsFile);
        } catch (IOException e) {
            System.out.println("Settings file was not found.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
