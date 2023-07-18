import java.time.LocalDate;

public class Worker {
    private String name;
    private String birthDate;
    protected String endDate;

    public Worker(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getAge() {
        return LocalDate.now().getYear() - Integer.parseInt(this.birthDate.substring(6));
    }

    public double collectPay(){
        return 0;
    }

    public void  terminate(String endDate){
        this.endDate = endDate;
    }
}
