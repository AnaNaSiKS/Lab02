import java.util.ArrayList;

public class Account {
    String name;
    double balance;
    String bankName;

    ArrayList<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getBankName() {
        return bankName;
    }


    public Account(String name, double balance, String bankName, ArrayList<User> users) {
        this.name = name;
        this.balance = balance;
        this.bankName = bankName;
        this.users = users;
    }

    @Override
    public String toString() {
        return "Название счета: " + name + " Баланс: " + balance;
    }
}
