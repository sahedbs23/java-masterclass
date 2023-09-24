package dev.lpa.ContactSetupChellange;

import java.util.*;

public class MapMain {
    public static void main(String[] args) {
        Collection<Contact> phones = ContactData.getData("phone");
        Collection<Contact> emails = ContactData.getData("email");

        List<Contact> fullLists = new ArrayList<>(phones);
        fullLists.addAll(emails);
        fullLists.forEach(System.out::println);
        System.out.println("-----------------------");


        Map<String, Contact> contacts = new HashMap<>();
        for (Contact contact : fullLists) {
            contacts.put(contact.getName(), contact);
        }
        contacts.forEach((k, v) -> System.out.println("Key= " + k + ", value= " + v));
        System.out.println("-".repeat(90));
        contacts.clear();


        for (Contact contact : fullLists) {
            Contact duplicate = contacts.put(contact.getName(), contact);

            if (duplicate != null) {
                System.out.println("Current contact -> " + contact);
                System.out.println("Duplicate contact -> " + duplicate);
            }
        }
        System.out.println("-".repeat(90));
        contacts.forEach((k, v) -> System.out.println("Key= " + k + ", value= " + v));
        contacts.clear();
        System.out.println("-".repeat(90));

        for (Contact contact : fullLists) {
            Contact duplicate = contacts.putIfAbsent(contact.getName(), contact);
            if (duplicate != null) {
                System.out.println("Current contact -> " + contact);
                System.out.println("Duplicate contact -> " + duplicate);
            }
        }
        System.out.println("-".repeat(90));
        contacts.forEach((k, v) -> System.out.println("Key= " + k + ", value= " + v));
        contacts.clear();
        System.out.println("-".repeat(90));

        for (Contact contact : fullLists) {
            Contact duplicate = contacts.putIfAbsent(contact.getName(), contact);
            if (duplicate != null) {
                contacts.put(contact.getName(), contact.mergeContact(duplicate));
            }
        }
        contacts.forEach((k, v) -> System.out.println("Key= " + k + ", value= " + v));
        System.out.println("-".repeat(90));
        System.out.println(contacts.get("Mickey Mouse"));

        System.out.println(contacts.getOrDefault("Moucky mouse", new Contact("Default contact")));
        System.out.println("-".repeat(90));
        contacts.clear();

        fullLists.forEach(contact -> contacts.merge(contact.getName(), contact, Contact::mergeContact));
        System.out.println("-".repeat(90));
        contacts.forEach((k, v) -> System.out.println("Key= " + k + ", value= " + v));

//        System.out.println("-".repeat(90));
//        for (String contactStr: new String[]{"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}) {
//            contacts.compute(contactStr, (k,v) -> new Contact(k));
//        }
//        contacts.forEach((k, v) -> System.out.println("Key= " + k + ", value= " + v));

        System.out.println("-".repeat(90));
        for (String contactStr: new String[]{"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}) {
            contacts.computeIfAbsent(contactStr, Contact::new);
        }
        contacts.forEach((k, v) -> System.out.println("Key= " + k + ", value= " + v));

        System.out.println("-".repeat(90));
        for (String contactStr: new String[]{"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}) {
            contacts.computeIfPresent(contactStr, (k,v) -> {
                v.addEmail("Fun Place");
                return v;
            });
        }
        contacts.forEach((k, v) -> System.out.println("Key= " + k + ", value= " + v));

        System.out.println("-".repeat(90));
        contacts.replaceAll((k,v) -> {
            String newEmail = k.replaceAll(" ", "") + "@funplace.com";
            v.replaceIfExist("DDuck@funplace.com",newEmail);
            return v;
        });
        contacts.forEach((k, v) -> System.out.println("Key= " + k + ", value= " + v));
        System.out.println("-".repeat(90));

        Contact daisy = new Contact("Daisy Jane Duck", "Daisyj@duck.com");
        Contact replacedContact = contacts.replace("Daisy Duck", daisy);
        System.out.println("New Contact: " + daisy);
        System.out.println("Replaced Contact: " + replacedContact);
        contacts.forEach((k, v) -> System.out.println("Key= " + k + ", value= " + v));

//        assert replacedContact != null;
//        Contact updatedContact = replacedContact.mergeContact(daisy);
//        boolean isSuccessful = contacts.replace("Daisy Duck", replacedContact, updatedContact);
//        System.out.println("-".repeat(90));
//        System.out.println("Updated Daisy: "+updatedContact);
//        if (isSuccessful){
//            System.out.println("Contact replaced successfully!");
//        }else {
//            System.out.printf("Contact replaced failed. The key and value didn't match %s %n", updatedContact);
//        }
//        contacts.forEach((k, v) -> System.out.println("Key= " + k + ", value= " + v));

        assert replacedContact != null;
        Contact updatedContact = replacedContact.mergeContact(daisy);
        boolean isSuccessful = contacts.replace("Daisy Duck", daisy, updatedContact);
        System.out.println("-".repeat(90));
        System.out.println("Updated Daisy: "+updatedContact);
        if (isSuccessful){
            System.out.println("Contact replaced successfully!");
        }else {
            System.out.printf("Contact replaced failed. The key %s and value %s didn't match %n", "Daisy Duck", updatedContact);
        }
        contacts.forEach((k, v) -> System.out.println("Key= " + k + ", value= " + v));

        System.out.println("-".repeat(90));

//        Contact removedContact = contacts.remove("Daisy Duck");
//        if (removedContact != null){
//            System.out.println("Contact removed "+removedContact);
//        }
//        contacts.forEach((k, v) -> System.out.println("Key= " + k + ", value= " + v));

        boolean removeSuccessful = contacts.remove("Daisy Duck", daisy);
        if (removeSuccessful){
            System.out.println("Contact removed successfully" + daisy);
        }else {
            System.out.printf("No matching contact found with key %s and value %s", "Daisy Duck", daisy);
        }
        contacts.forEach((k, v) -> System.out.println("Key= " + k + ", value= " + v));

    }
}
