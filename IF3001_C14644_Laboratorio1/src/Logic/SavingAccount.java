/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.util.Date;

/**
 *
 * @author Laboratorios
 */
public class SavingAccount extends Account{
    private Date date;
    private int monthlyTerm;
    private float interest;

    public SavingAccount(Date date, int monthlyTerm, float interest, String numberAccout, Client client, double balance, CommercialBank commercialBank) {
        super(numberAccout, client, balance, commercialBank);
        this.date = date;
        this.monthlyTerm = monthlyTerm;
        this.interest = interest;
    }

    public SavingAccount(Date date, int monthlyTerm, float interest) {
        this.date = date;
        this.monthlyTerm = monthlyTerm;
        this.interest = interest;
    }
    
    public SavingAccount() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMonthlyTerm() {
        return monthlyTerm;
    }

    public void setMonthlyTerm(int monthlyTerm) {
        this.monthlyTerm = monthlyTerm;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    @Override
    public String toString() {
        return super.toString()+"\nSavingAccount: " + "\nDate: " + date + "\nMonthlyTerm: " + monthlyTerm + "\nInterest: " + this.interest;
    }

    

    @Override
    public double interestCalculation() {
        double totalInterest ;
        totalInterest = this.getMonthlyTerm()*this.getInterest()*this.getBalance();
        
        return this.getBalance()+totalInterest;
    }

    @Override
    public void withdraw(double money) {
        if (money > super.getBalance()) {
             System.out.println("You dont have enough money");
           
        }
        super.setBalance(this.getBalance() - money);
         System.out.println(money+" Has Been withDrawn");
    }

    @Override
    public void deposit(double money) {
        if (money > 0) {
            super.setBalance(super.getBalance()+money);
        }
        
    }
    
    @Override
    public boolean sinpeMovil(String phone, double sendMoney) {
        this.withdraw(sendMoney);
        return super.getCommercialBank().letSimpeMovil(sendMoney, phone);
    }
    
}
