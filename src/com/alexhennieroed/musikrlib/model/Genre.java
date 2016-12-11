package com.alexhennieroed.musikrlib.model;

/**
 * An enum of different genres of music
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
public enum Genre {

    ROCK("Rock"),
    POP("Pop"),
    HIPHOP("Hip-Hop"),
    DANCE("Dance"),
    COUNTRY("Country"),
    METAL("Metal"),
    REGGAE("Reggae"),
    DUBSTEP("Dubstep")
    ;

    private String name;

    Genre(String name) {
        this.name = name;
    }

    public String getName() { return name; }

}
