package tb;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 11.03.2018.
 */
public class Bot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        Message msg = update.getMessage();
        String txt = msg.getText();
        if (txt.equals("/start")) {
            SendMsg(msg, "Привет! Этот бот поможет тебе подобрать правильный размер одежды и узнать, как лучше ухаживать за ней.");
        }
        else if(txt.equals("Уход")) {
            SendMes(msg, "Введите название материала");
        }
        else if(txt.equals("Размер")) {
            SendMes(msg, "Введите обхват груди, талии и бедер");
        }
        else if(checkString(txt)){
            Info info = new Info();
            String inf;
            inf = info.getSize(txt);
            SendMsg(msg, inf);
        }
        else {
            Info info = new Info();
            String inf;
            inf = info.getCare(txt);
            SendMsg(msg, inf);
        }
    }

    public boolean checkString(String string) {
        if (string == null || string.length() == 0) return false;

        char c;
            c = string.charAt(0);
            if ((c >= '0' && c <= '9')) {
                return true;
            }
        return false;
    }

    private void SendMes(Message message, String text){

        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId());

        sendMessage.setText(text);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
    
    private void SendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId());
        //sendMessage.setReplyToMessageId(message.getMessageId());

        // Создаем клавиуатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add("Размер");
        keyboardFirstRow.add("Уход");

        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
        //keyboard.add(keyboardSecondRow);
        replyKeyboardMarkup.setKeyboard(keyboard);

        sendMessage.setText(text);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "perfect_clothes_bot";
    }

    @Override
    public String getBotToken() {
        return "521310091:AAG6-qiHDmzy3HsDo0VTdq0a7SjjY9o220g";
    }

}


