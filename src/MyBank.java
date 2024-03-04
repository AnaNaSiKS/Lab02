import javax.swing.*;
import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MyBank implements ATMMachine {
    private final String BANK_NAME = "MyBank";

    public void checkBalance(User user) {
        if (checkPin(user))
            System.out.println(" Текущий баланс: " + chooseAccount(user).getBalance());
    }

    public void depositBalance(User user, double money) {
        if (checkPin(user)){
            Account chooseAccount = chooseAccount(user);
            chooseAccount.setBalance(chooseAccount.getBalance() + money);
            System.out.println(" Текущий баланс: " + chooseAccount.getBalance());
        }
    }

    public void withdraw(User user, double money) {
        if (checkPin(user)){
            Account chooseAccount = chooseAccount(user);
            if (chooseAccount.getBankName().equals(BANK_NAME)) {
                if (chooseAccount.getBalance() >= money){
                    chooseAccount.setBalance(chooseAccount.getBalance() - money);
                    System.out.println("Снято: "+ money + "Комиссия 0%"+" Текущий баланс: " + chooseAccount.getBalance() );
                }
                else System.out.println("Недостаточно средств");
            }
            else {
                if (chooseAccount.getBalance() >= (money * 1.02)){
                    chooseAccount.setBalance(chooseAccount.getBalance() - money * 1.02);
                    System.out.println("Снято: "+money + " Комиссия 2%"+" Текущий баланс: " + chooseAccount.getBalance());
                }
                else System.out.println("Недостаточно средств");
            }
        }
    }

    public void transferMoney(User inUser, User outUser,double money) {
        if (checkPin(inUser)){
            Account chooseInAccount = chooseAccount(inUser);
            System.out.println("Выберите на какой счет перевести средства");
            Account chooseOutAccount = chooseAccount(outUser);
            if (chooseInAccount.getBalance() >= money){
                chooseInAccount.setBalance(chooseInAccount.getBalance() - money);
                chooseOutAccount.setBalance(chooseOutAccount.getBalance() + money);
                System.out.println(inUser.getFirstName() + " " + inUser.getName()
                        + " Перевёл: " + money +
                        " Кому: " + outUser.getFirstName() + " " + outUser.getName());
            }
            else System.out.println("Недостаточно средств");
        }
    }
    public boolean checkPin(User user){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пин-код");
        if (user.getPin().equals(scanner.next()))
            return true;
        System.out.println("Неверный пин-код");
        return false;
    }

    @Override
    public Account chooseAccount(User user) {
        if (user.getAccounts().size() > 1) {
            int i = 1;
            for(Account account : user.getAccounts()){
                System.out.println(i + " " + account.toString());
                i++;
            }
            Scanner scanner = new Scanner(System.in);
            return user.getAccounts().get(scanner.nextInt() - 1);
        }
        else if (!user.getAccounts().isEmpty()){
            return null;
        }
        else return user.getAccounts().getFirst();
    }
}
