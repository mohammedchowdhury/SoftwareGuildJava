/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.FlooringMastery.service;

/**
 *
 * @author mohammedchowdhury
 */
public class NoOrderException extends Exception {

    public NoOrderException(String message) {
        super(message);
    }

    public NoOrderException(String message,  Throwable cause) {
        super(message, cause);
    }

}
