package com.gmail.arthurstrokov.translatorbot.exceptions;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Arthur Strokov
 * @email arthurstrokov@gmail.com
 * @created 13.11.2022
 */
@Data
@Getter
@Setter
@ToString
public class ExceptionMessage {

    private int status;
    private String reason;
}
