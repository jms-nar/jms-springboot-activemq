package com.jms.jmsspringbootactivemq.model;

import java.io.Serializable;

public class Email implements Serializable{
    private String to;
    private String message;

    public Email(String to, String message) {
        this.to = to;
        this.message = message;
    }

    public Email() {
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("Email{to=%s, body=%s}", getTo(), getMessage());
    }
}
