/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

/**
 *
 * @author mohammedchowdhury
 */
public class ItemDataValidationException extends Exception {

    public ItemDataValidationException(String message) {
        super(message);
    }

    public ItemDataValidationException(String message, Throwable cause) {
        super(message, cause);
    }

}
