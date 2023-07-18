public class HiredEmployee extends Employee{
    private double annualSalary;
    private boolean isRetired;

    public HiredEmployee(String name, String birthDate, long employeeId, String hireDate, double annualSalary, boolean isRetired) {
        super(name, birthDate, employeeId, hireDate);
        this.annualSalary = annualSalary;
        this.isRetired = isRetired;
    }

    public  void  retire(){
        System.out.println(this.getAge());
            this.terminate("19-07-2023");
            System.out.println(this.collectPay());

    }

    @Override
    public double collectPay() {
        int totalServiceYear = Integer.parseInt(this.endDate.substring(6)) - Integer.parseInt(this.hireDate.substring(6));
        return ((this.annualSalary * totalServiceYear) / 100) * 10 ;
    }
}
