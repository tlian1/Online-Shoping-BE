package Interfece;

public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();

        Worker worket1 = new Worker("Worket1" , 5);
        Worker worket2 = new Worker("Worket2" , 15);
        Worker worket3 = new Worker("Worket3" , 25);
        Worker worket4 = new Worker("Worket4" , 35);

        Worker[] workers = {
                new Worker("Worket1", 5),
                new Worker("Worket2", 15),
                new Worker("Worket3", 25),
                new Worker("Worket4", 35)
        };

        for (int i = 0; i < workers.length; i++){
            System.out.println(workers[i]);
        }

        int sumSalaries = 0;
        for (Worker worker : workers) {
            sumSalaries += worker.sumAllsalaries();
        }
        System.out.printf("All salaries %d ", sumSalaries);

        worket1.addMoney(57);
        System.out.println();
        System.out.println(worket1.getSalary());

        hospital.getAccept(worket1);
        hospital.getAccept(worket2);
        hospital.showPatiets();

    }
}
