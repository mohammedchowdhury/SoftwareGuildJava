package com.mohammedchowdhury.bullsandcows.service;
/**
 *
 * @author mohammedchowdhury
 */
public class NoSuchGameException extends Exception {
    public NoSuchGameException(String message) {
        super(message);
    }
    public NoSuchGameException(String message, Throwable cause) {
        super(message, cause);
    }
}