package dev.lpa.ContactSetupChellange;

import java.util.*;

public class ContactMain {
    public static void main(String[] args) {
        Collection<Contact> phones = ContactData.getData("phone");
        Collection<Contact> emails = ContactData.getData("email");
        emails.forEach(System.out::println);

        // crete a tree set. Interface type should implement a comaprator. as Contact do not have
        // any comparator implementation, let's add a comparator.
        Comparator<Contact> contactComparator = Comparator.comparing(Contact::getName);
        NavigableSet<Contact> sorted = new TreeSet<>(contactComparator);
        sorted.addAll(phones);
        sorted.forEach(System.out::println);

        // String by default implement comaprator. so we do not have to implement comparator for string.
        // let's see the example here
        System.out.println("-".repeat(90));
        NavigableSet<String> sets = new TreeSet<>();
        phones.forEach(p -> sets.add(p.getName()));
        System.out.println(sets);
        System.out.println("-".repeat(90));

        // we can create tree sets from tree sets. we do not have to implement comparator again as previous tree
        //sets already have the comparator attached.
        NavigableSet<Contact> fullSets = new TreeSet<>(sorted);
        fullSets.addAll(emails);
        fullSets.forEach(System.out::println);
        System.out.println("-".repeat(90));

        // we can reuse the comparator that being used with a tree set.
        // let's see the example.
        //let's create a collection
        System.out.println("Printing full lists");
        List<Contact> fullLists = new ArrayList<>(phones);
        fullLists.sort(sorted.comparator());
        fullLists.forEach(System.out::println);
        System.out.println("-".repeat(90));

        Contact min = Collections.min(fullSets, sorted.comparator());
        Contact max = Collections.max(fullSets,sorted.comparator());

        Contact first = fullSets.first();
        Contact last = fullSets.last();

        System.out.printf("min: %s first: %s%n",min.getName(),first.getName());
        System.out.printf("max: %s last: %s%n",max.getName(),last.getName());

        System.out.println("-------------");
        System.out.println(fullSets.pollFirst());
        System.out.println(fullSets.pollLast());
        System.out.println("-------------");
        fullSets.forEach(System.out::println);

        Contact daffy = new Contact("Daffy Duck");
        Contact daisy = new Contact("Daisy Duck");
        Contact snoopy = new Contact("Snoopy");
        Contact archie = new Contact("Archie");

        for (Contact c: List.of(daffy, daisy, last, snoopy)){
            System.out.printf("ceiling(%s)=%s%n",c.getName(),fullSets.ceiling(c));
            System.out.printf("higher(%s)=%s%n",c.getName(),fullSets.higher(c));
        }
        System.out.println("--------------------");

        for (Contact c: List.of(daffy, daisy, first, archie)) {
            System.out.printf("floor(%s)=%s%n",c.getName(),fullSets.floor(c));
            System.out.printf("lower(%s)=%s%n",c.getName(),fullSets.lower(c));
        }
        System.out.println("-".repeat(90));

        // let's reverse the sets
        NavigableSet<Contact> descendantSets = fullSets.descendingSet();
        System.out.println("-".repeat(90));
        System.out.println("descendant Sets");
        System.out.println("-".repeat(90));
        descendantSets.forEach(System.out::println);

        Contact contact = descendantSets.pollLast();
        System.out.printf("Pulled from full sets %s%n",contact);
        System.out.println("--".repeat(90));
        System.out.println("descendant Sets 1");
        descendantSets.forEach(System.out::println);
        System.out.println("--".repeat(90));
        System.out.println("descendant Sets 2");
        System.out.println("--".repeat(90));
        fullLists.forEach(System.out::println);
        System.out.println("--".repeat(90));


        Contact marion = new Contact("Maid Marion");
        var headSet = fullSets.headSet(marion,true);
        System.out.println("-".repeat(90));
        System.out.println("Head Sets");
        System.out.println("-".repeat(90));
        headSet.forEach(System.out::println);

        var tailSet = fullSets.tailSet(marion,false);
        System.out.println("-".repeat(90));
        System.out.println("Tail Sets");
        System.out.println("-".repeat(90));
        tailSet.forEach(System.out::println);

        System.out.println("subsets");
        var subset = fullSets.subSet(new Contact("Linus Van Pelt"), false, marion,true);
        subset.forEach(System.out::println);
    }
}
