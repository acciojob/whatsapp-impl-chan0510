package com.driver;

import java.util.Date;

public class Message {
    private int id;
    private String content;
    private Date timestamp;
    private static int count = 1;
    private User sender;
    private Group group;
    public Message(String content, User sender, Group group) {
        this.id = count++;
        this.content = content;
        this.timestamp = new Date();
        this.sender = sender;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public User getSender() {
        return sender;
    }

    public Group getGroup() {
        return group;
    }

}

