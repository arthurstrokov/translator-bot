package com.gmail.arthurstrokov.translatorbot.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @author Артур Александрович Строков
 * @email astrokov@clevertec.ru
 * @created 21.10.2022
 */
@Configuration
@Getter
@RefreshScope
public class GlobalProperties {

    @Value("${bot.name}")
    private String botName;
    @Value("${bot.token}")
    private String botToken;
    @Value("${lingvo.api.key}")
    private String lingvoApiKey;
    @Value("${lingvo.api.srcLang}")
    private String srcLang;
    @Value("${lingvo.api.dstLang}")
    private String dstLang;
}
