package dev.lpa.ContactSetupChellange;

import java.util.*;

public class MapViewMain {
    public static void main(String[] args) {

        Map<String,Contact> contacts = new HashMap<>();

        ContactData.getData("phone").forEach(c -> contacts.put(c.getName(), c));
        ContactData.getData("email").forEach(c -> contacts.put(c.getName(), c));

        Set<String> keysView = contacts.keySet();
        System.out.println(keysView);

        Set<String> copyOfKeys = new TreeSet<>(contacts.keySet());
        System.out.println(copyOfKeys);

        if (contacts.containsKey("Linus Van Pelt")){
            System.out.println("Linus and I go way back,so of course I have info");
        }

        keysView.remove("Daffy Duck");
        System.out.println(keysView);
        contacts.forEach((k,v) -> System.out.println(v));

        copyOfKeys.remove("Linus Van Pelt");
        System.out.println(contacts);
        contacts.forEach((k,v) -> System.out.println(v));

        keysView.retainAll(List.of("Linus Van Pelt", "Mickey Mouse", "Charlie Brown", "Robin Hood"));
        System.out.println(keysView);
        contacts.forEach((k,v) -> System.out.println(v));

        keysView.clear();
        System.out.println(contacts);

        ContactData.getData("phone").forEach(c -> contacts.put(c.getName(),c));
        ContactData.getData("email").forEach(c -> contacts.put(c.getName(),c));
        System.out.println(keysView);

        var values = contacts.values();
        values.forEach(System.out::println);

        values.retainAll(ContactData.getData("email"));
        System.out.println("Key views" + keysView);
        contacts.forEach((k,v) -> System.out.println(v));

        System.out.println("-".repeat(90));
        List<Contact> list = new ArrayList<>(values);
        list.sort(Comparator.comparing(Contact::getNameLastFirst));
        list.forEach(c -> System.out.println(c.getNameLastFirst() + ": "+c));

        System.out.println("-".repeat(90));
        Contact first = list.get(0);
        contacts.put(first.getNameLastFirst(), first);
        values.forEach(System.out::println);
        keysView.forEach(System.out::println);
        System.out.println("-".repeat(90));

        HashSet<Contact>  set = new HashSet<>(values);
        set.forEach(System.out::println);
        if (set.size() <= contacts.keySet().size()){
            System.out.println("We got duplicates values");
        }

        System.out.println("-".repeat(90));
        var nodeSets = contacts.entrySet();
        for (var node :nodeSets) {
            System.out.println(nodeSets.getClass().getName());
            if (!node.getKey().equals(node.getValue().getName())){
                System.out.println(node.getClass().getName());
                System.out.println("Keys doesn't match name " + node.getKey() + " : " + node.getValue());
            }
        }
    }
}
