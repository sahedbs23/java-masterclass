package dev.NestedClasess;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RunMethods {
    public static void main(String[] args) {

        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(1005,"Borkot", 1961,"Morol Store"),
                new StoreEmployee(1006,"Jubaida", 1965,"Dorji Store"),
                new StoreEmployee(1901,"Solaiman", 1969,"Morol Store"),
                new StoreEmployee(1980,"Marzia", 1985,"Palowan Store"),
                new StoreEmployee(2001,"Sahadat", 1988,"KGF"),
                new StoreEmployee(2003,"Sahed", 1991,"Inamgine")
        ));

        class NameSort implements Comparator<Employee>{

            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }


        var c3 = new NameSort();
        var c0 = new EmployeeComparator<StoreEmployee>();
        var c1 = new Employee.EmployeeComparator();
        var c2 = new StoreEmployee().new StoreEmployeeComparator<>();
        sortIt(storeEmployees, c0);
        sortIt(storeEmployees, c1);
        sortIt(storeEmployees, c2);
        sortIt(storeEmployees, c3);
        sortIt(storeEmployees, new Comparator<Employee>(){
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        sortIt(storeEmployees, (Comparator<Employee>) (o1, o2) -> o1.getName().compareTo(o2.getName()));
        sortIt(storeEmployees, (Comparator<Employee>) Comparator.comparing(Employee::getName));
        sortIt(storeEmployees, Comparator.comparing(Employee::getName));


    }

    public static<T> void sortIt(List<T> lists, Comparator<? super T> comparator){
        System.out.println("Sorting with comparator " + comparator.toString());
        System.out.println("Sorting with comparator");
        lists.sort(comparator);

        for (var employee : lists){
            System.out.println(employee);
        }
    }
}
