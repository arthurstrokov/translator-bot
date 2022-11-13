package com.gmail.arthurstrokov.translatorbot.exceptions;

/**
 * @author Arthur Strokov
 * @email arthurstrokov@gmail.com
 * @created 13.11.2022
 */
public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
