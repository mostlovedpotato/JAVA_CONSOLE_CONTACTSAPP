package org.potatoe.tutchallenge1;

public class Message {
    private String text;
    private String receipient;
    private int id;

    public Message(String text, String receipient, int id) {
        this.text = text;
        this.receipient = receipient;
        this.id = id;
    }

    public void getDetails(){
        System.out.println("Receipient : " + this.receipient + "\nMessage : "
        + this.text + "\n Id : " + this.id);
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getReceipient() {
        return receipient;
    }

    public void setReceipient(String receipient) {
        this.receipient = receipient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
