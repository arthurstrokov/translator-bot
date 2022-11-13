package com.gmail.arthurstrokov.translatorbot.exceptions;

/**
 * @author Arthur Strokov
 * @email arthurstrokov@gmail.com
 * @created 13.11.2022
 */
public class ResourceBadRequestException extends Exception {

    public ResourceBadRequestException(String errorMessage) {
        super(errorMessage);
    }
}
