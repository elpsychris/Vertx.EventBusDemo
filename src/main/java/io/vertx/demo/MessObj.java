package io.vertx.demo;

public class MessObj {
    private String mess;
    private String receiver;
    private String sender;

    public MessObj(String mess, String receiver, String sender) {
        this.mess = mess;
        this.receiver = receiver;
        this.sender = sender;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
