package dev.lpa.ContactSetupChellange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactData {

    private static final String phoneData = """
            Charlie Brown, 3334445555
            Maid Marion, 1234567890
            Mickey Mouse, 9998887777
            Mickey Mouse, 1247489758
            Minnie Mouse, 4567805666
            Robin Hood, 5647893000
            Robin Hood, 7899028222
            Lucy Van Pelt, 5642086852
            Mickey Mouse, 9998887777
            """;

    private static final String emailData = """
            Mickey Mouse, mckmouse@gmail.com
            Mickey Mouse, micky1@aws.com
            Minnie Mouse, minnie@verizon.net
            Robin Hood, rhood@gmail.com
            Linus Van Pelt, lvpelt2015@gmail.com
            Daffy Duck, daffy@google.com
            """;

    private String phoneContacts = """
    Sahed Moral, 1714999720
    Rejuana Rahman, 1730445377
    Tabassum Promy, 1614999720
    Liza Akter, 1814999720
    Imran Hossain, 1514999720
    Mostafizur Rahman, 1314999720
    Sahed Moral, 1714999720
            """;

    private String emailContacts = """
    Sahed Moral, sahed.moral@123rf.com
    Rejuana Rahman, rejuana.khan@gmail.com
    Tabassum Promy, promypromy@gmail.com
    Liza Akter, lizasolaiman@gmail.com
    Imran Hossain, hossainImran@outlook.com
    Mostafizur Rahman, rahman@outlook.com
    Sahed Moral, sahed.moral@123rf.com
            """;

    public static List<Contact> getData(String type){
        List<Contact> contactList = new ArrayList<>();
        Scanner scanner = new Scanner(type.equals("email") ? emailData : phoneData);
        while (scanner.hasNextLine()){
            String[] contactInputs = scanner.nextLine().split(",");
            Arrays.asList(contactInputs).replaceAll(String::trim);
            if (type.equals("email")){
                contactList.add(new Contact(contactInputs[0], contactInputs[1]));
            } else if (type.equals("phone")) {
                contactList.add(new Contact(contactInputs[0], Long.parseLong(contactInputs[1])));
            }
        }

        return contactList;
    }


}
