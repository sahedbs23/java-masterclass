package dev.lpa.ContactSetupChellange;

import java.util.HashSet;
import java.util.Set;

public class Contact {
    private String name;
    private Set<String> emails = new HashSet<>();
    private Set<String> phones = new HashSet<>();

    public Contact(String name) {
        this(name,null);
    }

    public Contact(String name, String email) {
        this(name,email,0);
    }

    public Contact(String name, long phone) {
        this(name,null,phone);
    }

    public Contact(String name, String email, long phone) {
        this.name = name;
        if (email != null){
            this.emails.add(email);
        }
        if (phone >0){
            var p = String.valueOf(phone);
            this.phones.add("(%s) %s-%s".formatted(p.substring(0,3),p.substring(3,6),p.substring(6)));
        }
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "%s: %s %s".formatted(name,emails,phones);
    }
    public Contact mergeContact(Contact contact){
       var newContact = new Contact(name);
       newContact.emails = new HashSet<>(this.emails);
       newContact.phones = new HashSet<>(this.phones);
       newContact.phones.addAll(contact.phones);
       newContact.emails.addAll(contact.emails);
       return newContact;
    }
}
