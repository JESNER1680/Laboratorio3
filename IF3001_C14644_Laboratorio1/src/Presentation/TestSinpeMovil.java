/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentation;

import Logic.Account;
import Logic.CentralBank;
import Logic.Client;
import Logic.CommercialBank;
import Logic.CurrentAccount;
import Logic.SavingAccount;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class TestSinpeMovil {

    public TestSinpeMovil() {
    }

    public void test() {
        CentralBank centralBank = new CentralBank("Central Bank CR");
        CommercialBank[] commercialBanks = new CommercialBank[2];

        commercialBanks[0] = new CommercialBank("BCR");
        commercialBanks[1] = new CommercialBank("BN");

        Account[] accounts = new Account[3];

        accounts[0] = new SavingAccount(new Date(), 0, 3, "1111", new Client("1234", "Jesner", "Juan Viñas", "4545"), 10000, commercialBanks[0]);
        accounts[1] = new CurrentAccount(2, "5555", new Client("1212", "Eliecer", "Cartago", "232323"), 0, commercialBanks[0]);
        accounts[2] = new SavingAccount(new Date(), 0, 3, "4444", new Client("3434", "Juan", "Turrialba", "3333"), 0, commercialBanks[0]);

        commercialBanks[0].setAccounts(accounts);
        commercialBanks[0].calculeBalanceBank();

        Account[] accounts2 = new Account[3];

        accounts2[0] = new SavingAccount(new Date(), 0, 3, "8989", new Client("8888", "Luis", "Juan Viñas", "2222"), 0, commercialBanks[1]);
        accounts2[1] = new CurrentAccount(2, "5555", new Client("6767", "Luisa", "Cartago", "232323"), 0, commercialBanks[1]);
        accounts2[2] = new SavingAccount(new Date(), 0, 3, "8888", new Client("5555", "Marta", "Turrialba", "5656"), 0, commercialBanks[1]);

        commercialBanks[1].setAccounts(accounts2);
        commercialBanks[1].calculeBalanceBank();

        centralBank.setBanks(commercialBanks);

        commercialBanks[0].setCentralBank(centralBank);
        commercialBanks[1].setCentralBank(centralBank);

        String phone = JOptionPane.showInputDialog("Write the phone to send the Sinpe Movil");
        String numberAccount = JOptionPane.showInputDialog("Write your number Account.");
        String sendMoney = JOptionPane.showInputDialog("¿How munch do you want to send?");

        System.out.println("Balance Outpdate = " + accounts[0].getBalance());
        System.out.println("Sinpe Movil Balance Outpdate = " + accounts2[0].getBalance());
        System.out.println("");
        Account account = null;

        for (int i = 0; i < centralBank.getBanks().length; i++) {
            if ((account = centralBank.getBanks()[i].findAccount(numberAccount)) != null) {
                if (account.sinpeMovil(phone, Double.parseDouble(sendMoney))) {
                    account.getCommercialBank().calculeBalanceBank();
                    System.out.println("");
                    System.out.println("its had send Sinpe Movil");
                    System.out.println("Balance update = " + accounts[0].getBalance());
                    System.out.println("Sinpe Movil Balance update = " + accounts2[0].getBalance() + "\n");
                    System.out.println("Affected Bank: " + centralBank.getBanks()[i].toString());
                }
                break;

            }
        }

    }
}
