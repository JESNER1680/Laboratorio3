/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

/**
 *
 * @author User
 */
public class CurrentAccount extends Account{
    private double interests;

    public CurrentAccount(double interests, String numberAccout, Client client, double balance, CommercialBank commercialBank) {
        super(numberAccout, client, balance, commercialBank);
        this.interests = interests;
    }

    public CurrentAccount() {
        
    }
    public double getInterests() {
        return interests;
    }

    public void setInterests(double interests) {
        this.interests = interests;
    }

    @Override
    public String toString() {
        return super.toString()+"\nCurrentAccount:\n" + "Interests: " + this.interests;
    }
    
    
    @Override
    public double interestCalculation() {
        return ((this.getBalance()*this.interests)/12);
    }

    @Override
    public void withdraw(double money) {
        if (money < super.getBalance() && money > 0) {
            super.setBalance(this.getBalance() - money);
            System.out.println(money + " Has Been withDrawn");
        }
        System.out.println("You dont have enough money");
    }

    @Override
    public void deposit(double money) {
        if (money > 0) {
            super.setBalance(super.getBalance()+money);
        }
    }

    @Override
    public boolean sinpeMovil(String phone,double sendMoney) {
        this.withdraw(sendMoney);
        return super.getCommercialBank().letSimpeMovil(sendMoney, phone);
    }
    
    
    
}
