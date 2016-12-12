package com.alexhennieroed.musikrlib.managers;

/**
 * An exception thrown if a setting is missing from the file
 * @author Alexander Hennie-Roed
 * @version 1.0.0
 */
class MissingSettingException extends RuntimeException {

    /**
     * Default constructor for the exception
     */
    public MissingSettingException() {
        super();
    }

    /**
     * Exception constructor that takes in a message
     * @param msg the exception message
     */
    public MissingSettingException(String msg) {
        super(msg);
    }

    /**
     * Exception constructor that takes in a message and throwable
     * @param msg the exception message
     * @param throwable the exception throwable
     */
    public MissingSettingException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

}
