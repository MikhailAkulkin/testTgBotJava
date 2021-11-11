package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class TestBot extends TelegramLongPollingBot {

    public static final String userNameBot = "AkulTestBot"; // уникальный юзернейм бота
    public static final String tokenBot = "2118247406:AAFZiILx_282iNljX4wvjAlOicEtqfQ40pk"; // уникальный токен бота
    @Override
    public void onUpdateReceived(Update update) { // бот запрашивает с определенным периодом изменения/апдейты и реагирует на них
    if (update.hasMessage()) { // если апдейт является сообщением
       Message message = update.getMessage(); // создает месседж и записывает в него полученное сообщение
       if (message.hasText()) { // проверяем что оно текстовое
           try { //обрабатываем требуемые исключения
               execute(SendMessage.builder(). // выполняем построение сообщения
                       chatId(message.getChatId().toString()). //получаем из экземпляра месседж id чата
                       text("Твое сообщение: \n\n" + message.getText()) // Создаем ответное сообщение, в данном случае зеркалим его
                       .build()); // даем указание на сборку билдеру
           } catch (TelegramApiException e) {
               System.out.println(e.getMessage());
           }
       }
    }
    }
    @Override
    public String getBotUsername() {
        return userNameBot;
    }

    @Override
    public String getBotToken() {
        return tokenBot;
    }
}
