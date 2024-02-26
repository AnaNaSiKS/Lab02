import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MyBank implements ATMMachine {
    public void checkBalance(User user, Account account ) {
        if (checkPin(user))
            System.out.println(" Текущий баланс: " +account.balance);
    }

    public void depositBalance(User user, Account account, double money) {
        if (checkPin(user)){
            account.setBalance(account.getBalance() + money);
            System.out.println(" Текущий баланс: " +account.balance);
        }
    }

    public void withdraw(User user,Account account, double money) {
        if (checkPin(user)){
            if (account.getBankName().equals("MyBank")) {
                if (account.getBalance() >= money){
                    account.setBalance(account.getBalance() - money);
                    System.out.println("Снято: "+ money + "Комиссия 0%"+" Текущий баланс: " + account.getBalance() );
                }
                else System.out.println("Недостаточно средств");
            }
            else {
                if (account.getBalance() >= (money * 1.02)){
                    account.setBalance(account.getBalance() - money * 1.02);
                    System.out.println("Снято: "+money + " Комиссия 2%"+" Текущий баланс: " + account.getBalance());
                }
                else System.out.println("Недостаточно средств");
            }
        }
    }

    public void transferMoney(User inUser, Account inAccount, User outUser,Account outAccount, double money) {
        if (checkPin(inUser)){
            if (inAccount.getBalance() >= money){
                inAccount.setBalance(inAccount.getBalance() - money);
                outAccount.setBalance(outAccount.getBalance() + money);
                System.out.println(inUser.getFirstName() + " " + inUser.getName()
                        + " Перевёл: " + money +
                        " Кому: " + outUser.getFirstName() + " " + outUser.getName());
            }
            else System.out.println("Недостаточно средств");
        }
    }

    public boolean checkPin (User user){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пин-код");
        if (user.getPin().equals(scanner.next()))
            return true;
        System.out.println("Неверный пин-код");
        return false;
    }
}
