package dev.lpa.tasks;

public enum Priority {
    LOW,
    MEDIUM,
    HIGH;

    public static Priority getPriority(String priorityString){
        if (priorityString.trim().equalsIgnoreCase("MEDIUM")) {
            return Priority.MEDIUM;
        } else if (priorityString.trim().equalsIgnoreCase("HIGH")) {
            return Priority.HIGH;
        }else {
            return Priority.LOW;
        }
    }
}
