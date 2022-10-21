package com.gmail.arthurstrokov.translatorbot.bot;

import com.gmail.arthurstrokov.translatorbot.configuration.GlobalProperties;
import com.gmail.arthurstrokov.translatorbot.service.LingvoApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * @author Артур Александрович Строков
 * @email astrokov@clevertec.ru
 * @created 21.10.2022
 */
@Slf4j
@RequiredArgsConstructor
public class TranslatorBot extends TelegramLongPollingBot {

    private final GlobalProperties globalProperties;
    private final LingvoApiService lingvoApiService;

    @Override
    public String getBotUsername() {
        return globalProperties.getBotName();
    }

    @Override
    public String getBotToken() {
        return globalProperties.getBotToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage().hasText()) {
            long chatId = update.getMessage().getChatId();
            String text = update.getMessage().getText();
            try {
                String auth = lingvoApiService.getAuth(globalProperties.getLingvoApiKey());
                String translated = lingvoApiService.getTranslate("Bearer " + auth, text, globalProperties.getSrcLang(), globalProperties.getDstLang());
                sendMsg(chatId, translated);
            } catch (Exception e) {
                log.info(e.getMessage());
                sendMsg(chatId, e.getMessage());
            }
        }
    }

    private void sendMsg(long chatId, String text) {
        SendMessage sendMessage = SendMessage.builder() // Create a message object
                .chatId(chatId)
                .text(text)
                .build();
        try {
            execute(sendMessage); // Sending our message object to user
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
