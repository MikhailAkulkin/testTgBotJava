package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MainAoo {
    public static void main(String[] args) { // точка входа
        TestBot bot = new TestBot(); // создаем экземпляр класса
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class); // инициализируем бота в Апи
            telegramBotsApi.registerBot(bot); // регистрируем его
        } catch (TelegramApiException e) {
            System.out.println(e.getMessage());
        }
    }
}
