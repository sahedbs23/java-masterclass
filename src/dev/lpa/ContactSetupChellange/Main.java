package dev.lpa.ContactSetupChellange;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Contact> emailContact = ContactData.getData("email");
        List<Contact> phoneContact = ContactData.getData("phone");
        printData("Email",emailContact);
        printData("Phone",phoneContact);
    }

    public static void printData(String header, List<Contact> contactList){
        System.out.println("----------------------------------------------------");
        System.out.println(header);
        System.out.println("----------------------------------------------------");
        contactList.forEach(System.out::println);
    }
}
