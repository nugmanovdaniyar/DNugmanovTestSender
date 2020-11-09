package ru.nugmanov.DNugmanovTestSender.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.nugmanov.DNugmanovTestSender.model.Message;
import ru.nugmanov.DNugmanovTestSender.service.MessageSenderService;

import java.util.*;

/**
 * Контроллер главной страницы
 *
 * @author NugmanovDT, 04.11.2020
 */
@Controller
@RequestMapping("/")
public class MainPageController {

    @Value("${text.values}")
    private List<String> textValues;

    @Value("${message.queue.name}")
    private String queueName;

    private final MessageSenderService messageSender;

    public MainPageController(MessageSenderService messageSender) {
        this.messageSender = messageSender;
    }

    /**
     * Отдает главную страницу вместе со списком значений для поля с выбором строки
     */
    @GetMapping()
    public String getMessages(Map<String, Object> model) {
        model.put("textValues", textValues);
        return "main";
    }

    /**
     * Отправляет сообщение в очередь и перенаправляет на главную страницу
     */
    @PostMapping()
    public String sendMessages(@RequestParam("number") int number,
                               @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date,
                               @RequestParam("text") String text) {
        Message message = new Message(number, date, text);
        messageSender.sendMessage(queueName, message);
        return "redirect:/";
    }
}
