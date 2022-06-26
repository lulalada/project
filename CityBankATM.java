package miniproject;

import java.util.Objects;
import java.util.Scanner;

import static miniproject.Database.allAccounts;

public class CityBankATM {
    public static void main(String[] args) {
        System.out.println("PLEASE ENTER YOUR ACCOUNT NUMBER:");
        Scanner sc = new Scanner(System.in);
        String account = sc.next();
        System.out.println("PLEASE ENTER YOUR PIN-CODE:");
        String pincode = sc.next();
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(allAccounts[i].getAccountNumber(), account) && Objects.equals(allAccounts[i].getPinCode(), pincode)){
                while (true) {
                    if (allAccounts[i] instanceof CityBankAccount) {
                        System.out.println("PRESS [1] TO CASH WITHDRAWAL");// снять деньги
                        System.out.println("PRESS [2] TO VIEW BALANCE"); // просмотр баланса
                        System.out.println("PRESS [3] TO CHANGE PIN CODE"); // изменить пин код
                        System.out.println("PRESS [4] TO CASH IN ACCOUNT"); // добавить деньги в счет
                        System.out.println("PRESS [5] TO VIEW ACCOUNT DATA"); // просмотр данные счета
                        System.out.println("PRESS [6] TO EXIT"); // выход);
                        int choice = sc.nextInt();
                        if (choice == 1) {
                            System.out.println("ENTER AMOUNT:");
                            int credit = sc.nextInt();
                            allAccounts[i].creditBalance(credit);
                            System.out.println("HERE IS MONEY: " + credit);
                        } else if (choice == 2) {
                            System.out.println("YOUR BALANCE: " + allAccounts[i].totalBalance());
                        } else if (choice == 3) {
                            System.out.println("ENTER NEW PIN-CODE:");
                            String newPin = sc.next();
                            allAccounts[i].setPinCode(newPin);
                            System.out.println("YOUR PIN-CODE SUCCESSFULLY CHANGED");
                        } else if (choice == 4) {
                            System.out.println("ENTER CASH:");
                            int debet = sc.nextInt();
                            allAccounts[i].debetBalance(debet);
                            System.out.println("PROCESS SUCCESSFULLY COMPLETED");
                        } else if (choice == 5) {
                            System.out.println("YOUR INFORMATION:");
                            System.out.println(allAccounts[i].accountData());
                        } else if (choice == 6) {
                            break;
                        }
                    }
                    else if (allAccounts[i] instanceof NationalBankAccount) {
                        //while (true) {
                        System.out.println("PRESS [1] TO CASH WITHDRAWAL");// снять деньги
                        System.out.println("PRESS [2] TO VIEW BALANCE"); // просмотр баланса
                        System.out.println("PRESS [3] TO EXIT"); // выход);
                        int choice = sc.nextInt();
                        if (choice == 1){
                            System.out.println("ENTER AMOUNT:");
                            int credit = sc.nextInt();
                            allAccounts[i].creditBalance(credit);
                            credit = credit - 200;
                            System.out.println("HERE IS MONEY: " + credit);
                        }
                        else if (choice == 2){
                            System.out.println("YOUR BALANCE:" + allAccounts[i].totalBalance());
                        }
                        else if (choice == 3){
                            break;
                        }
                    }
                }
            }
        }
    }
}

