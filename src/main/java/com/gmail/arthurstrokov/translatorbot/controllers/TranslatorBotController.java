package com.gmail.arthurstrokov.translatorbot.controllers;

import com.gmail.arthurstrokov.translatorbot.gateway.TranslatorBotFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Arthur Strokov
 * @email arthurstrokov@gmail.com
 * @created 13.11.2022
 */
@RestController
@RequiredArgsConstructor
public class TranslatorBotController {

    private final TranslatorBotFeignClient translatorBotFeignClient;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/authenticate")
    public String getAuth(@RequestHeader("Authorization") String auth) {
        return translatorBotFeignClient.getAuth(auth, "");
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/translate")
    public String getTranslate(@RequestHeader("Authorization") String token,
                               @RequestParam("text") String text,
                               @RequestParam("srcLang") String srcLang,
                               @RequestParam("dstLang") String dstLang) {
        return translatorBotFeignClient.getTranslate(token, text, srcLang, dstLang);
    }
}
