package dev.lpa.LocalAnomnyous;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Sahed", "Moral", "2015-12-15"));
        employees.add(new Employee("Rejuana", "Rahman", "2023-01-01"));
        employees.add(new Employee("Promy", "Promy", "2019-12-01"));
        employees.add(new Employee("Abdur Rahman", "Sajid", "2018-06-18"));
        employees.add(new Employee("Amena Azrin", "Maliha", "1978-04-18"));
        employees.add(new Employee("Lima", "Akter", "1990-04-18"));
        employees.add(new Employee("Liza", "Akter", "1985-11-24"));

        printEmployee(employees, "hireDate");
        System.out.println("-".repeat(50));
        printEmployee(employees, null);
    }

    public static void printEmployee(List<? extends Employee> employees, String sortField){

        class DecorateEmployee {
            private Employee employee;
            private String fullName;
            private int workingYears;

            public DecorateEmployee(Employee employee) {
                this.employee = employee;
                this.fullName = employee.firstName() + " " +employee.lastName();
                this.workingYears = LocalDate.now().getYear() -  LocalDate.parse(employee.hireDate()).getYear();
            }
        }

        List<DecorateEmployee> decorateEmployees = new ArrayList<>(employees.size());
        for (Employee employee : employees){
            decorateEmployees.add(new DecorateEmployee(employee));
        }

        var comparator = new Comparator<DecorateEmployee>(){
            @Override
            public int compare(DecorateEmployee o1, DecorateEmployee o2) {
                if (Objects.equals(sortField,"hireDate")){
                    return o1.workingYears - o2.workingYears;
                }else {
                    return o1.fullName.compareTo(o2.fullName);
                }
            }
        };


        decorateEmployees.sort(comparator);

        for (DecorateEmployee decorateEmployee:decorateEmployees){
            System.out.printf("%s has been employee for %d years %n",decorateEmployee.fullName, decorateEmployee.workingYears);
        }
    }
}
