public class Account {
    private String accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public Account() {
        this("111",
                20.00,
                "sahed",
                "donotreplay@123rf.com",
                "88023456"
        );
        System.out.println("Calling constructor with no-params");
    }

    public Account(
            String accountNumber,
            double balance,
            String customerName,
            String email,
            String phoneNumber
    ) {

        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        System.out.println("Constructor called with all params");
    }

    public Account(String customerName, String email, String phoneNumber) {
        this("111",20.00,customerName, email, phoneNumber);
        System.out.println("Constructor called with 3 params");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean withdraw(double withdrawAmount) {
        if (this.balance < withdrawAmount) {
            return false;
        }
        this.balance = this.balance - withdrawAmount;
        return true;
    }

    public boolean deposit(double depositAmount) {
        this.balance = this.balance + depositAmount;
        return true;
    }
}
