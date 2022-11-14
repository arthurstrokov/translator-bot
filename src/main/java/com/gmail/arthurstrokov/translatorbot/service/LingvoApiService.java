package com.gmail.arthurstrokov.translatorbot.service;

import com.gmail.arthurstrokov.translatorbot.gateway.TranslatorBotFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author Артур Александрович Строков
 * @email astrokov@clevertec.ru
 * @created 21.10.2022
 */
@Service
@RequiredArgsConstructor
public class LingvoApiService {

    private final TranslatorBotFeignClient translatorBotFeignClient;

    @Cacheable("auth")
    public String getAuth(String lingvoApiKey) {
        return translatorBotFeignClient.getAuth(lingvoApiKey, "");
    }

    public String getMinicard(String token, String text, String srcLang, String dstLang) {
        return translatorBotFeignClient.getTranslate(token, text, srcLang, dstLang);
    }
}
