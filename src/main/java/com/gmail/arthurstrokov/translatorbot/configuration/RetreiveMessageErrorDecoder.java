package com.gmail.arthurstrokov.translatorbot.configuration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.arthurstrokov.translatorbot.exceptions.*;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.SneakyThrows;

/**
 * @author Arthur Strokov
 * @email arthurstrokov@gmail.com
 * @created 13.11.2022
 */
public class RetreiveMessageErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder errorDecoder = new Default();

    @SneakyThrows
    @Override
    public Exception decode(String methodKey, Response response) {
        ExceptionMessage message = new ExceptionMessage();
        message.setStatus(response.status());
        message.setReason(response.reason());

        ObjectMapper objectMapper = new ObjectMapper();
        String errorMessage = objectMapper.writeValueAsString(message);

        return switch (response.status()) {
            case 400 -> new ResourceBadRequestException(errorMessage);
            case 401 -> new ResourceUnauthorizedException(errorMessage);
            case 404 -> new ResourceNotFoundException(errorMessage);
            case 405 -> new ResourceMethodNotAllowedException(errorMessage);
            default -> errorDecoder.decode(methodKey, response);
        };
    }
}
