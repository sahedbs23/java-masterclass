package dev.lpa.tasks;

import java.util.Objects;

public class Task implements Comparable<Task> {
    private String assignee;
    private String project;
    private String description;
    private TaskStatus status;
    private Priority priority;

    public Task(String project, String description, Priority priority) {
        this(project, description, priority, null, TaskStatus.NOT_ASSIGNED);
    }

    public Task(String project, String description, Priority priority, String assignee) {
        this(project, description,priority, assignee, assignee == null ? TaskStatus.NOT_ASSIGNED : TaskStatus.ASSIGNED);
    }

    public Task(String project, String description,Priority priority, String assignee, TaskStatus status) {
        this.project = project;
        this.description = description;
        this.priority = priority;
        this.assignee = assignee;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(getProject(), task.getProject()) && Objects.equals(getDescription(), task.getDescription());
    }

    @Override
    public int hashCode() {
        return 31 * Objects.hash(getProject(), getDescription());
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(Task o) {
        int result = project.compareTo(o.project);
        if (result == 0) {
            result = description.compareTo(o.description);
        }
        return result;
    }

    @Override
    public String toString() {
        return "%-20s %-25s %-10s %-10s %s".formatted(project, description, priority, assignee, status);
    }
}
