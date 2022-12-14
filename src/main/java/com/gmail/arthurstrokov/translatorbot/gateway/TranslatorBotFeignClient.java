package com.gmail.arthurstrokov.translatorbot.gateway;

import com.gmail.arthurstrokov.translatorbot.configuration.FeignSupportConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author Артур Александрович Строков
 * @email astrokov@clevertec.ru
 * @created 21.10.2022
 */
@FeignClient(name = "api-client", url = "https://developers.lingvolive.com/api", configuration = {FeignSupportConfig.class})
public interface TranslatorBotFeignClient {

    @PostMapping("/v1.1/authenticate")
    String getAuth(
            @RequestHeader("Authorization") String auth,
            @RequestBody String insteadOfContentLength
    );

    @GetMapping("/v1/Minicard")
    String getMinicard(
            @RequestHeader("Authorization") String auth,
            @RequestParam("text") String text,
            @RequestParam("srcLang") String srcLang,
            @RequestParam("dstLang") String dstLang
    );

    @GetMapping("/v1/Translation")
    String getTranslation(
            @RequestHeader("Authorization") String auth,
            @RequestParam("text") String text,
            @RequestParam("srcLang") String srcLang,
            @RequestParam("dstLang") String dstLang,
            @RequestParam("isCaseSensitive") String isCaseSensitive);
}
