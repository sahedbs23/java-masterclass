package dev.sahedmoral.arraylistchallenage;

import java.util.ArrayList;
import java.util.Objects;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact>  myContacts;

    public MobilePhone(String myNumber){
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }
    public boolean addNewContact(Contact contact){
        if (findContact(contact) >= 0){
            return false;
        }
        return myContacts.add(contact);
    }

    public boolean removeContact(Contact contact){
        return myContacts.remove(contact);
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int indexOf = myContacts.indexOf(oldContact);
        if (indexOf<0){
            return false;
        }
        myContacts.set(indexOf, newContact);
        return true;

    }

    private int findContact(Contact contact){
        return findContact(contact.getName());
    }

    private int findContact(String contact){
        for (int i =0; i<myContacts.size(); i++){
            if (Objects.equals(myContacts.get(i).getName(), contact)){
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String contact){
        for (Contact curentLoopContact : myContacts) {
            if (Objects.equals(curentLoopContact.getName(), contact)) {
                return curentLoopContact;
            }
        }
        return null;
    }

    public void printContacts(){
        System.out.println("Contact List:");
        for (int i =0; i<myContacts.size(); i++){
            Contact contact = myContacts.get(i);
            System.out.printf("%d. %s -> %s",i+1, contact.getName(), contact.getPhoneNumber());
        }

    }
}
