/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

/**
 *
 * @author User
 */
public class CentralBank {
    private CommercialBank[]banks;
    private String nameCentralBank;
    public CentralBank(String nameCentralBank) {
        this.nameCentralBank = nameCentralBank;
    }

    public CommercialBank[] getBanks() {
        return banks;
    }

    public void setBanks(CommercialBank[] banks) {
        this.banks = banks;
    }
    
    public boolean doTransaction(double sendMoney, CommercialBank commercialBank, String phone){
        for (int i = 0; i < this.banks.length; i++) {
            for (int j = 0; j < this.banks[i].getAccounts().length; j++) {
                if (this.banks[i].getAccounts()[j].getClient().getPhone().equalsIgnoreCase(phone)) {
                    if (commercialBank.getBalanceBank() >= sendMoney) {
                       this.banks[i].getAccounts()[j].deposit(sendMoney);
                       this.banks[i].calculeBalanceBank();
                       System.out.println("General information from Bank: "+this.banks[i].toString());
                       return true;
                    }
 
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String information = "";
        information +="NAME: "+this.nameCentralBank;
        return information;
    }
    
    
    
}
