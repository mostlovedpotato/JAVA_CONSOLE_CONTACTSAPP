package org.potatoe.tutchallenge1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Contact> contacts;
    private static Scanner sc;
    private static int id = 0;
   public static void main(String[] args) {


        contacts = new ArrayList<>();
        System.out.println("hello User : " );
        showInitialOptions();

    }
    private static void showInitialOptions(){
        System.out.println("Please Select One : " + "\n\t1. Manage Contacts" +
                "\n\t2. Messages " + "\n\t3. Quit");
        sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch(choice){
            case 1 :
                manageContacts();
                break;
            case 2 :
                manageMessages();
                break;
            default:
                break;
        }
    }

    private static void manageMessages() {
        System.out.println("Please Select one : " + "\n\t1. Show All Messages : " +
                "\n\t2. Send A Message : " + "\n\t3. Go Back");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                showAllMessages();
                break;
            case 2:
                sendNewMessage();
                break;
            default:
                showInitialOptions();
                break;
        }
    }

    private static void sendNewMessage() {
        System.out.println("Enter the Name to Send the Msg : ");
        String name = sc.nextLine();
        if(name.equals("")){
            System.out.println("Please Enter the name : ");
            sendNewMessage();
        }else{
            boolean doesExist = false;
            for(Contact c : contacts){
                if(c.getName().equals(name)){
                    doesExist=true;
                }
            }
            if(doesExist){
                System.out.println("What's the Message : ");
                String txt = sc.nextLine();
                if(txt.equals("")){
//                    System.out.println("");
                    sendNewMessage();
                }else{
                    id++;
                    Message newMsg = new Message(txt,name,id);
                    for(Contact c : contacts){
                        if(c.getName().equals(name)){
                            ArrayList<Message> newMsgs = c.getMessages();
                            newMsgs.add(newMsg);
                            c.setMessages(newMsgs);
                        }
                    }
                }
            }else{
                System.out.println("There is no such contact !!");
            }
        }
        showInitialOptions();
    }

    private static void showAllMessages() {
        ArrayList<Message> allMsg = new ArrayList<>();
        for(Contact c : contacts){
            allMsg.addAll(c.getMessages());
        }
        if(allMsg.size()>0){
            for(Message m : allMsg){
                m.getDetails();
                System.out.println("------------------------");
            }
        }else{
            System.out.println("You don't have any Messages ");
        }
        showInitialOptions();
    }

    private static void manageContacts(){
        System.out.println("Please Select one : "+ "\n\t1. Show all Contact " + "\n\t2. Add Contact"+
        "\n\t3. Search a Contact " + "\n\t4. Delete a contact " + "\n\t5. Go back");

        int choice = sc.nextInt();
        switch(choice){
            case 1 :
                showAllContact();
                break;
            case 2 :
                addNewContact();
                break;
            case 3:
                searchContact();
                break;
            case 4:
                deleteContact();
                break;
            default:
                showInitialOptions();
                break;
        }
    }

    private static void deleteContact() {
        System.out.println("Please Enter the name : ");
        String name = sc.nextLine();
        if(name.equals("")){
//            System.out.println();
            deleteContact();
        }else{
            boolean doesExist = false;
            for (Contact c : contacts){
                if(c.getName().equals(name)){
                    doesExist = true;
                    contacts.remove(c);
                }
            }
            if(!doesExist){
                System.out.println("Contact Does not Exist !!!");
            }
        }
        showInitialOptions();
    }

    private static void searchContact() {
        System.out.println("Please Enter the Name to Search For : ");
        String name = sc.nextLine();
        if(name.equals("")){
            System.out.println("Please Enter the name : ");
            searchContact();
        }else{
            boolean doesExist=false;
            for(Contact c : contacts){
                if(c.getName().equals(name)){
                    doesExist = true;
                    c.getDetails();
                }
            }
            if(!doesExist){
                System.out.println("Contact DOes not Exist ...");
            }

        }
        showInitialOptions();
    }

    private static void addNewContact() {
        System.out.println("New contact : ");
        System.out.println("Enter the Name : ");
        String name = sc.nextLine();
        System.out.println("Enter Contact Number : ");
        String number = sc.nextLine();
        System.out.println("Enter the email : ");
        String email = sc.nextLine();
        if(name.equals("") || number.equals("") || email.equals("")){
            System.out.println("Please Enter all of Information : ");
            addNewContact();
        }else{
            boolean doesExist = false;
            for(Contact c : contacts){
                if(c.getName().equals(name)){
                    doesExist=true;
                }
            }
            if(doesExist){
                System.out.println("We have contact with this name !! ");
            }else{
                Contact contact = new Contact(name,number,email);
                contacts.add(contact);
                System.out.println("Contact added successfully !!");
            }

        }
        showInitialOptions();
    }

    private static void showAllContact() {
        for (Contact c : contacts){
            c.getDetails();
        }
        showInitialOptions();
    }

}
