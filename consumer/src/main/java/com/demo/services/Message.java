package com.demo.services;

public class Message {
    private long id;
    private String message;

    public Message(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Message() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
