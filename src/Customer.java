public class Customer {
    private String name;
    private int creditLimit;
    private String email;

    public Customer(String name, String email, int creditLimit) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }
    public Customer() {
        this("Default custom name", "defaul@123rf.com");
    }

    public Customer(String name, String email) {
        this(name, email,0 );
    }

    public String getName() {
        return name;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }


}
