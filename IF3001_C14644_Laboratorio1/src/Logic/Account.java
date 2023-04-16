/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

/**
 *
 * @author Laboratorios
 */
public abstract class Account {
    private String numberAccount;
    private Client client;
    private double balance;
    private CommercialBank commercialBank;
    public Account() {
    }
    

    public Account(String numberAccout, Client client, double balance, CommercialBank commercialBank) {
        this.numberAccount = numberAccout;
        this.client = client;
        this.balance = balance;
        this.commercialBank = commercialBank;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccout) {
        this.numberAccount = numberAccout;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public CommercialBank getCommercialBank() {
        return commercialBank;
    }

    public void setCommercialBank(CommercialBank commercialBank) {
        this.commercialBank = commercialBank;
    }
    
    public abstract double interestCalculation();
    public abstract void withdraw(double money);
    public abstract void deposit(double money);    
    public abstract boolean sinpeMovil(String phone,double sendMoney);
    @Override
    public String toString() {
        return "NumberAccount: " + numberAccount + "\nClient: " + client + "\nBalance: " + balance;
    }
    
    
}
