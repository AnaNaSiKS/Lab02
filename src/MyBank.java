import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MyBank implements ATMMachine {
    public void checkBalance(Account account, User user) {
        if (checkPin(user))
            System.out.println(account.balance);
        else System.out.println("Неверный пинкод");
    }

    public boolean depositBalance(User user, double money) {
        return false;
    }

    public boolean withdraw(User user, double money) {
        return false;
    }

    public boolean transferMoney(User inUser, User outUser, double money) {
        return false;
    }

    public boolean checkPin (User user){
        Scanner scanner = new Scanner(System.in);
        return user.pin.equals(scanner.next());
    }
}
