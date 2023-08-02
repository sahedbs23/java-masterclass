package dev.sahedmoral.boxingunboxing.banking;

import java.util.ArrayList;
import java.util.Objects;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name){
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String name, double initialTransaction){
        if (findCustomer(name) != null){
            return false;
        }

        Customer customer = new Customer(name, initialTransaction);
        return customers.add(customer);
    }

    public boolean addCustomerTransaction(String customerName, double transactionAmount){
        Customer customer = findCustomer(customerName);
        if (customer == null) {
            return false;
        }
        customer.addTransaction(transactionAmount);
        return true;
    }

    private Customer findCustomer(String customerName){
        for (Customer customer : customers){
            if (Objects.equals(customer.getName(), customerName)){
                return customer;
            }
        }
        return null;
    }
}
