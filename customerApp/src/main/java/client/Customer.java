package client;

public class Customer {

    private String name;
    private int number;
    private int balance;

    public Customer(String nom, int id, int solde) {
        this.name = nom;
        this.number = id;
        this.balance = solde;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return this.getName() + " | " +  this.getNumber()  +  " | " + this.getBalance() + "€" + "  ";
    }
}
