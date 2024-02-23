public class Account {
    String name;
    double balance;
    String bankName;

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

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Account(String name, double balance, String bankName) {
        this.name = name;
        this.balance = balance;
        this.bankName = bankName;
    }
}
