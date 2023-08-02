package dev.sahedmoral.boxingunboxing;

import java.util.ArrayList;
import java.util.Objects;

public class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name){
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public boolean addCustomer(String customerName){
        Customer customer = findCustomer(customerName);
        if (customer != null){
            return true;
        }
        return customers.add(new Customer(customerName));
    }

    public boolean addTransaction(String customerName, double amount){
        Customer customer = findCustomer(customerName);
        if (customer == null){
            return false;
        }
        return customer.getTransactions().add(amount);
    }

    public void printStatement(String customerName){
            Customer customer = findCustomer(customerName);
            if (customer != null) {
                var transactions = customer.getTransactions();
                for (double transaction : transactions) {
                    System.out.printf("%s -> %f %n",customer.getName(), transaction);
                }
            }
    }

    private Customer findCustomer(String customerName){
        for (Customer customer : customers){
            if(Objects.equals(customerName,customer.getName())){
                return customer;
            }
        }

        return null;
    }

}
