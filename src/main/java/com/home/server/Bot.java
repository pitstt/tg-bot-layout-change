package com.home.server;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.logging.Level;

import static org.telegram.telegrambots.logging.BotLogger.log;

public class Bot extends TelegramLongPollingBot {

    private final String token;

    public Bot() {
        //Токен беру из переменной среды heroku
        token = System.getenv("TOKEN");
    }

    /**
     * Метод для приема сообщений.
     *
     * @param update Содержит сообщение от пользователя.
     */
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        sendMsg(update.getMessage().getChatId().toString(), message);
    }

    /**
     * Метод для настройки сообщения и его отправки.
     *
     * @param chatId  id чата
     * @param message Строка, которую отправил пользователь.
     */
    public synchronized void sendMsg(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        if (message.equals("/start")) {
            sendMessage.setText("Бот предназначен для быстрой онлайн конвертации введенного текста в другую раскладку. " +
                    "Поддерживаются английский и русский языки.\n");
        } else {
            MessageConverter messageConverter = new MessageConverter();
            sendMessage.setText(messageConverter.layoutChange(message));
        }
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            log(Level.SEVERE, "Exception: ", e.toString());
        }
    }

    /**
     * Метод возвращает имя бота, указанное при регистрации.
     *
     * @return имя бота
     */
    public String getBotUsername() {
        return "LayoutChange_bot";
    }

    /**
     * Метод возвращает token бота для связи с сервером Telegram
     *
     * @return token для бота
     */
    @Override
    public String getBotToken() {
        return token;
    }
}