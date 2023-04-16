/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

/**
 *
 * @author User
 */
public class CommercialBank {
    
    private Account[] accounts;
    private String nameBank;
    private CentralBank centralBank;
    private double balanceBank;
    public CommercialBank(Account[] accounts, String nameBank, CentralBank centralBank) {
        this.accounts = accounts;
        this.nameBank = nameBank;
        this.balanceBank = 0;
    }
    
    public CommercialBank(String nameBank) {
        this.nameBank = nameBank;
        this.balanceBank = 0;
        
    }

    public String getNameBank() {
        return nameBank;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    public CentralBank getCentralBank() {
        return centralBank;
    }

    public void setCentralBank(CentralBank centralBank) {
        this.centralBank = centralBank;
    }
    
    public void calculeBalanceBank(){
        this.balanceBank = 0;
        for (int i = 0; i < this.accounts.length; i++) {
            this.balanceBank+=this.accounts[i].getBalance();
        }
    }
    public Account[] getAccounts() {
        return accounts;
    }
    
    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public double getBalanceBank() {
        return balanceBank;
    }

    public void setBalanceBank(double balanceBank) {
        this.balanceBank = balanceBank;
    }
    
    public boolean letSimpeMovil(double sendMoney, String phone) {
        return this.centralBank.doTransaction(sendMoney, this, phone);
    }
    public Account findAccount(String numberAccount){
        for (int i = 0; i < this.accounts.length; i++) {
            if (this.accounts[i].getNumberAccount().equalsIgnoreCase(numberAccount)) {
                return this.accounts[i];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String information = "";
        information+= "\nNameBank: " + nameBank + "\nCentralBank: " + centralBank + "\nBalanceBank: " + balanceBank+"\n";
        for (int i = 0; i < this.accounts.length; i++) {
            information += "\nAccount "+(i+1)+":\n"+this.accounts[i].toString()+"\n";
        } 
        return information;
    }
    
    
}
