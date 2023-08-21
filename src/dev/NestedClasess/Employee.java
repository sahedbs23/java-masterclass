package dev.NestedClasess;

import java.util.Comparator;
import java.util.Objects;

public class Employee {

    public static class EmployeeComparator implements Comparator<Employee> {

        private String comparatorType;

        public EmployeeComparator() {
            this("name");
        }

        public EmployeeComparator(String comparatorType) {
            this.comparatorType = comparatorType;
        }

        @Override
        public int compare(Employee o1, Employee o2) {
            if (Objects.equals(comparatorType, "yearStarted")){
                return o1.yearStarted - o2.yearStarted;
            }
            return o1.name.compareTo(o2.name);
        }
    }
    private int employeeId;
    private String name;
    private int yearStarted;

    public Employee() {
    }

    public Employee(int employeeId, String name, int yearStarted) {
        this.employeeId = employeeId;
        this.name = name;
        this.yearStarted = yearStarted;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "%-15d %-15s %d".formatted(employeeId,name,yearStarted);
    }
}
