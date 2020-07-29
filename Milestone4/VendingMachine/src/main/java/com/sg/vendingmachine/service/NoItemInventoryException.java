package com.sg.vendingmachine.service;
/**
 *
 * @author mohammedchowdhury
 */
public class NoItemInventoryException extends Exception {

    public NoItemInventoryException(String message) {
        super(message);
    }

    public NoItemInventoryException(String message, Throwable cause) {
        super(message, cause);
    }
}