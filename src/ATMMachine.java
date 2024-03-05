import java.util.Scanner;

public interface ATMMachine {
    public void checkBalance(User user);
    public void depositBalance(User user);
    public void withdraw(User user);
    public void transferMoney(User inUser, User outUser);
    public boolean checkPin (User user);
    public Account chooseAccount(User user);
}
