package dev.sahedmoral.boxingunboxing.banking;

import java.util.ArrayList;
import java.util.Objects;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name){
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String name){
        Branch branch = findBranch(name);
        if(branch != null){
            return false;
        }
        return this.branches.add(new Branch(name));
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransactionAmount){
        Branch branch = findBranch(branchName);
        if (branch == null){
            return false;
        }
        return branch.newCustomer(customerName,initialTransactionAmount);
    }

    public boolean addCustomerTransaction(String branchName,  String customerName, double initialTransactionAmount){
        Branch branch = findBranch(branchName);
        if (branch == null){
            return false;
        }

        return branch.addCustomerTransaction(customerName, initialTransactionAmount);
    }

    private Branch findBranch(String branchName){
        for (Branch branch : branches){
            if (Objects.equals(branch.getName(), branchName)){
                return branch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean printTransaction){
        Branch branch = findBranch(branchName);
        if (branch == null){
            return false;
        }
        System.out.printf("Customer details for branch %s%n", branch.getName());
        for (int i = 0; i < branch.getCustomers().size(); i++) {
            Customer customer = branch.getCustomers().get(i);
            System.out.printf("Customer: %s[%d]%n",customer.getName(),i+1);
            if (printTransaction){
                System.out.println("Transactions");
                var transactions = customer.getTransactions();
                for (int j = 0; j < transactions.size(); j++) {
                    double transaction = transactions.get(j);
                    System.out.printf("[%d]  Amount %f%n", j+1, transaction);
                }
            }
        }
        return true;
    }
}
