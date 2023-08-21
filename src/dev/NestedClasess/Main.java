package dev.NestedClasess;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
            new Employee(1005,"Sahed", 2022),
            new Employee(1001,"Rejuana", 2023),
            new Employee(1003,"Lima", 2020),
            new Employee(1010,"Liza", 2019),
            new Employee(1009,"Promy", 2018)
        ));

        employees.sort(new Employee.EmployeeComparator("yearStarted"));
        for (Employee employee : employees){
            System.out.println(employee);
        }

        System.out.println("-".repeat(20));

        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(1005,"Borkot", 1961,"Morol Store"),
                new StoreEmployee(1006,"Jubaida", 1965,"Dorji Store"),
                new StoreEmployee(1901,"Solaiman", 1969,"Morol Store"),
                new StoreEmployee(1980,"Marzia", 1985,"Palowan Store"),
                new StoreEmployee(2001,"Sahadat", 1988,"KGF"),
                new StoreEmployee(2003,"Sahed", 1991,"Inamgine")
        ));

        storeEmployees.sort(new StoreEmployee().new StoreEmployeeComparator().reversed());
        for (StoreEmployee storeEmployee : storeEmployees){
            System.out.println(storeEmployee);
        }
        System.out.println("-".repeat(30));
        addPigLatinName(storeEmployees);


    }

    public static void addPigLatinName(List<? extends Employee> employees){
        final String lastName = "Piggy";

        class DecoratedEmployee extends Employee implements Comparable<DecoratedEmployee> {
            private final String pigLatinName;
            private final Employee originalInstance;

            private DecoratedEmployee(String pigLatinName, Employee originalInstance){
                this.pigLatinName = pigLatinName + " " + lastName;
                this.originalInstance = originalInstance;
            }

            public String toString(){
                return originalInstance.toString() + " " + pigLatinName;
            }

            @Override
            public int compareTo(DecoratedEmployee o) {
                return pigLatinName.compareTo(o.pigLatinName);
            }
        }

        List<DecoratedEmployee> decoratedEmployees = new ArrayList<>(employees.size());
        for (Employee employee : employees){
            String name =  employee.getName();
            String piggy = name.substring(1) + name.charAt(0) + "ay";
            decoratedEmployees.add(new DecoratedEmployee(piggy,employee));
        }
        decoratedEmployees.sort(null);

        for (var dEmployee : decoratedEmployees){
            System.out.println(dEmployee.originalInstance.getName() + " " + dEmployee.pigLatinName);
        }
    }
}
