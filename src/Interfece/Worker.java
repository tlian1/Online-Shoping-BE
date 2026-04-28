package Interfece;

public class Worker implements Finansable {
    private String name;
    private int salary;

    public Worker(String name, int salary){
        this.name = name;
        this.salary = salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public  int addMoney(int found) {
        salary += found;
        return salary;
    }

    @Override
    public int sumAllsalaries() {
        return this.salary;
    }


    @Override
    public String getMysalary(int amount) {
        return "Salary:" + amount + "has been got";
    }


    @Override
    public int pay(int amount) {
        return salary - amount;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Worker{" +
                "name" + name + "\'" +
                ", salary=" + salary +
                '}';
    }
}
