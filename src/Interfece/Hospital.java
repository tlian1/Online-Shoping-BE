package Interfece;

import java.util.ArrayList;

public class Hospital implements Hospitaltable, Finansable {
    private String name;
    private ArrayList<Worker> pattiens;
    private int wallet;
    public Hospital() {
        this.pattiens = new ArrayList<>();
        this.wallet = 0;
    }

    public void addPatient(Worker worker) {
        pattiens.add(worker);
        System.out.println("New patient has been added to list");
    }
    public void showPatiets() {
        int count = 0;
        for (Worker w : pattiens) {
            System.out.println(++count + ". " + w.getName());
        }
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public ArrayList<Worker> getPattiens() {
        return pattiens;
    }

    public void setPattiens(ArrayList<Worker> pattiens) {
        this.pattiens = pattiens;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "pattients=" + pattiens +
                '}';
    }

    @Override
    public String getMysalary(int amount) {
        return "";
    }


    @Override
    public int sumAllsalaries() {
        return 0;
    }


    @Override
    public int pay(int amount) {
        return wallet + amount;
    }

    @Override
    public void getAccept(Worker worker) {
        pattiens.add(worker);
        System.out.println("New patient has been added to list");

    }
}
