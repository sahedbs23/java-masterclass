package dev.lpa.tasks;

import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Set<Task> allTasks= TaskData.getData("All");
        Set<Task> bobTasks= TaskData.getData("bob");
        Set<Task> annTasks= TaskData.getData("ann");
        Set<Task> carolTasks= TaskData.getData("carol");
        sortAndPrintTasks("All Task", allTasks);
        Comparator<Task> sortByPriority = Comparator.comparing(Task::getPriority);
        sortAndPrintTasks("Ann's task", annTasks, sortByPriority);

        List<Set<Task>> sets = List.of(bobTasks, annTasks, carolTasks);
        Set<Task> assignedTasks = getUnion(sets);
        sortAndPrintTasks("Assigned tasks", assignedTasks);

        Set<Task> everyTasks = getUnion(List.of(assignedTasks, allTasks));
        sortAndPrintTasks("The true all tasks", everyTasks);

        Set<Task> missingTasks = getDifferance(everyTasks,allTasks);
        sortAndPrintTasks("Missing assigned tasks", missingTasks);

        Set<Task> notAssignedTasks = getDifferance(allTasks,assignedTasks);
        sortAndPrintTasks("Not assigned tasks", notAssignedTasks);

        Set<Task> overlap = getUnion(List.of(
                getIntersect(annTasks,bobTasks),
                getIntersect(carolTasks,bobTasks),
                getIntersect(annTasks,carolTasks)
        ));
        sortAndPrintTasks("Overlap tasks", overlap, sortByPriority);

        List<Task> overlaping = new ArrayList<>();
        for (Set<Task> set : sets){
            Set<Task> dupes = getIntersect(set, overlap);
            overlaping.addAll(dupes);
        }

        Comparator<Task> priorityNatural = sortByPriority.thenComparing(Comparator.naturalOrder());
        sortAndPrintTasks("Overlaping...",overlaping, priorityNatural);
    }

    public static Set<Task> getUnion(List<Set<Task>> sets){
        Set<Task> union = new HashSet<>();
        for (Set<Task> task: sets) {
            union.addAll(task);
        }
        return union;
    }

    public static Set<Task> getIntersect(Set<Task> t1, Set<Task> t2){
        Set<Task> union = new HashSet<>(t1);
        union.retainAll(t2);
        return union;
    }

    public static Set<Task> getDifferance(Set<Task> t1, Set<Task> t2){
        Set<Task> union = new HashSet<>(t1);
        union.removeAll(t2);
        return union;
    }



    public static void sortAndPrintTasks(String header, Collection<Task> tasks){
        sortAndPrintTasks(header,tasks,null);
    }

    public static void sortAndPrintTasks(String header, Collection<Task> tasks, Comparator<Task> sorter){
        System.out.println("-".repeat(90));
        System.out.println(header);
        System.out.println("-".repeat(90));
        List<Task> tasks1 = new ArrayList<>(tasks);
        tasks1.sort(sorter);
        tasks1.forEach(System.out::println);
        System.out.printf("%n%n");
    }
}
