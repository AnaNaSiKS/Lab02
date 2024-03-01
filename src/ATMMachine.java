import java.util.Scanner;

public interface ATMMachine {
    public void checkBalance(User user);
    public void depositBalance(User user, double money);
    public void withdraw(User user, double money);
    public void transferMoney(User inUser, User outUser, double money);
    public boolean checkPin (User user);
    public Account chooseAccount(User user);
}
