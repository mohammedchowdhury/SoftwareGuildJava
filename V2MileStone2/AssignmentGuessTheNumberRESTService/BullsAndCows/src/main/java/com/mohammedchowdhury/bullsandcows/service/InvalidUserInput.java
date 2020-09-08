package com.mohammedchowdhury.bullsandcows.service;

/**
 *
 * @author mohammedchowdhury
 */
public class InvalidUserInput extends Exception {

    public InvalidUserInput(String message) {
        super(message);
    }

    public InvalidUserInput(String message, Throwable cause) {
        super(message, cause);
    }

}
