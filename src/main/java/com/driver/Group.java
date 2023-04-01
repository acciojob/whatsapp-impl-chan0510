package com.driver;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private int numberOfParticipants;
    private static int count = 1;
    private int id;
    private User admin;
    private List<User> userList;
    private List<Message> messages;
    public Group(User admin, List<User> userList) {
        if(userList.size()<2){
            throw new IllegalArgumentException("User list should contain at least 2 users");
        }
        this.id = count++;
        this.userList = userList;
        this.admin = admin;
        this.messages = new ArrayList<>();
        if(userList.size() == 2){
            name = userList.get(1).getName();
        }else{
            name = "Group " + count;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message message){
        messages.add(message);
    }

    public void removeUser(User user){
        if(user == admin){
            throw new IllegalArgumentException("Admin cannot be removed");
        }
        userList.remove(user);
        messages.removeIf(message -> message.getSender() == user);
    }

    public int getNumberOfMessages(){
        return messages.size();
    }

    public boolean containsUser(User user){
        return userList.contains(user);
    }

}


