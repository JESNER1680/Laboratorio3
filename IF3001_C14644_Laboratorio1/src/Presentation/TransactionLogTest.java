/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentation;

import Logic.Account;
import Logic.Client;
import Logic.CommercialBank;
import Logic.SavingAccount;
import java.util.Date;

/**
 *
 * @author Laboratorios
 */
public class TransactionLogTest {
    public TransactionLogTest() {
        
    }
    public void test(){
        Client clients[] = new Client[10];
        clients[0] = new Client("30404040404","Luis", "TurryCity", "88888");
        Date date = new Date(2022,3,1);
        Account accounts[] = new Account[10];
        accounts[0] = new SavingAccount(date, 12, 0.02f, "1", clients[0], 100000, new CommercialBank("BACK"));
        TransactionLog[] tl = new TransactionLog[5];
        accounts[0].withdraw(25000);
        tl[0] = new TransactionLog("WithDraw", accounts[0], 25000);
        
        for (int i = 0; i < tl.length; i++) {
            if (tl[i] != null) {
                System.out.println(tl[i].toString());
            }
        }
    }
        
}
