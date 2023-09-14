package dev.lpa.tasks;

import java.util.*;

public class TaskData {
    private static final String allTask = """
            Infrastructure, Logging, High
            Infrastructure, DB Access, Medium
            Infrastructure, Security, High
            Infrastructure, Password Policy, Medium
            Data Design, Task Table, Medium
            Data Design, Employee Table, Medium
            Data Design, Cross Reference Tables, High
            Data Design, Encryption Policy, High
            Data Access, Write Views, Low
            Data Access, Set Up Users, Low
            Data Access, Set Up Access Policy, Low
            """;


    private static final String annTask = """
            Infrastructure, Security, High, In Progress
            Infrastructure, Password Policy,Medium, In Progress
            Research, Cloud solutions, Medium, In Progress
            Data Design, Encryption Policy, High
            Data Design, Project Table, Medium
            Data Access, Write Views,Low, In Progress
            """;

    private static final String bobTask = """
            Infrastructure, Security, High, In Progress
            Infrastructure, Password Policy, Medium
            Data Design,Encryption Policy,High
            Data Access,Write Views, Low, In Progress
            """;

    private static final String carolTask = """
            Infrastructure, Logging, High, In Progress
            Infrastructure, DB Access, Medium
            Infrastructure, Password Policy, Medium
            Data Design, Task Table, High
            Data Access, Write Views, Low
            """;

    public static Set<Task> getData(String owner) {
        String assingee = "ann,bob,carol".contains(owner.toLowerCase()) ? owner : null;
        String selectedLists = switch (owner){
            case "ann" -> annTask;
            case "bob" -> bobTask;
            case "carol" -> carolTask;
            default -> allTask;
        };
        Set<Task> tasks = new HashSet<>();
        Scanner scanner = new Scanner(selectedLists);
        while (scanner.hasNextLine()) {
            String[] inputs = scanner.nextLine().split(",");
            Arrays.asList(inputs).replaceAll(String::trim);
            Priority priority = Priority.valueOf(inputs[2].toUpperCase());
            if (inputs.length == 4) {
                tasks.add(new Task(inputs[0], inputs[1], priority, assingee, TaskStatus.valueOf(inputs[3].replace(' ', '_').toUpperCase())));
            } else {
                tasks.add(new Task(inputs[0], inputs[1], priority, assingee));
            }
        }
        return tasks;
    }
}
