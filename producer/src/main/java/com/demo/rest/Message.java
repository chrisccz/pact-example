package com.demo.rest;

public class Message {
    private long id;
    private String message;

    public Message(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Message() {
        this.id=1;
        this.message="Hello";
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
