package ru.nugmanov.DNugmanovTestSender.model;

import javax.xml.bind.annotation.*;
import java.util.Date;

/**
 * Сущность - Сообщение
 *
 * @author NugmanovDT, 04.11.2020
 */
@XmlRootElement(name = "account")
@XmlAccessorType(XmlAccessType.FIELD)
public class Message {
    @XmlElement
    private long number;

    @XmlElement
    private Date date;

    @XmlElement
    private String text;

    public Message() {}

    public Message(int number, Date date, String text) {
        this.number = number;
        this.date = date;
        this.text = text;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
