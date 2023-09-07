package dev.lpa.ContactSetupChellange;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Contact> emails = ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");
        printData("Email", emails);
        printData("Phone", phones);


        Set<Contact> emailSets = new HashSet<>(emails);
        Set<Contact> phoneSets = new HashSet<>(phones);

        printData("Email sets", emailSets);
        printData("Phone sets", phoneSets);

        int indexOf = emails.indexOf(new Contact("Robin Hood"));
        Contact robinHood = emails.get(indexOf);
        robinHood.addEmail("Sherwood Forest");
        robinHood.addEmail("Sherwood Forest");
        robinHood.replaceIfExist("RHood@sherwoodforest.com","RHood@sherwoodforest.org");
        System.out.println(robinHood);

        Set<Contact> unionAB = new HashSet<>();
        unionAB.addAll(emailSets);
        unionAB.addAll(phoneSets);
        printData("(A ∪ B) Union of Email (A) with phone (B)", unionAB);


        Set<Contact> intersectAB = new HashSet<>(emailSets);
        intersectAB.retainAll(phoneSets);
        printData("(A ∩ B) Intersection of Email (A) with phone (B)", intersectAB);


        Set<Contact> intersectBA = new HashSet<>(phones);
        intersectBA.retainAll(emailSets);
        printData("(B ∩ A) Intersection of Phone (B) with email (A)", intersectBA);


        Set<Contact> AMinusB = new HashSet<>(emailSets);
        AMinusB.removeAll(phoneSets);
        printData("(A - B) Email (A) - phones (B)", AMinusB);


        Set<Contact> BMinusA = new HashSet<>(phoneSets);
        BMinusA.removeAll(emailSets);
        printData("(B - A) Phones (B) - emails (A)", BMinusA);


        Set<Contact> symmetricDifference = new HashSet<>(AMinusB);
        symmetricDifference.addAll(BMinusA);
        printData("Symmetric difference Email (A) and Phone (B)", symmetricDifference);

        Set<Contact> symmetricDifference2 = new HashSet<>(unionAB);
        symmetricDifference2.removeAll(intersectAB);
        printData("Symmetric difference 2 Email (A) and Phone (B)", symmetricDifference2);




    }

    public static void printData(String header, Collection<Contact> contactList) {
        System.out.println("----------------------------------------------------");
        System.out.println(header);
        System.out.println("----------------------------------------------------");
        contactList.forEach(System.out::println);
    }
}
