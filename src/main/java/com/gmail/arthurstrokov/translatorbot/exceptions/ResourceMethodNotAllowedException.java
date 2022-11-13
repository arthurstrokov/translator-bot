package com.gmail.arthurstrokov.translatorbot.exceptions;

/**
 * @author Arthur Strokov
 * @email arthurstrokov@gmail.com
 * @created 13.11.2022
 */
public class ResourceMethodNotAllowedException extends Exception {

    public ResourceMethodNotAllowedException(String message) {
        super(message);
    }
}
