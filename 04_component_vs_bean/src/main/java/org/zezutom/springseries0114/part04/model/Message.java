package org.zezutom.springseries0114.part04.model;

public class Message {

    private String title;

    private String text;

    public Message(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
