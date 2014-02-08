package org.zezutom.springseries0114.part04.model;

public class MessageBuilder {

    public Message getInstance(String title, String text) {
        return new Message(title, text);
    }
}
