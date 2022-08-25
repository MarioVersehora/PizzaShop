package com.codingshadows.auth.exception;

public class PizzaAlreadyInMenuException extends Exception {

    String message;

    public PizzaAlreadyInMenuException(String message) {
        this.message = message;
    }

    public String toString() {
        return "PizzaAlreadyInMenuException Occured : " + message;
    }

}
