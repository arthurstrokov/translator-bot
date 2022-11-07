package com.gmail.arthurstrokov.translatorbot;

import com.gmail.arthurstrokov.translatorbot.bot.TranslatorBot;
import com.gmail.arthurstrokov.translatorbot.configuration.GlobalProperties;
import com.gmail.arthurstrokov.translatorbot.service.LingvoApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@EnableCaching
@EnableFeignClients
@EnableDiscoveryClient
@RequiredArgsConstructor
@SpringBootApplication
public class TranslatorBotApplication {

    private final GlobalProperties globalProperties;
    private final LingvoApiService lingvoApiService;

    public static void main(String[] args) {
        SpringApplication.run(TranslatorBotApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new TranslatorBot(globalProperties, lingvoApiService));
        };
    }
}
