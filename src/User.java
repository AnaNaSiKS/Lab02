import java.util.ArrayList;

public class User {
    private String firstName;
    private String name;
    private int id;
    private String pin;
    private ArrayList<Account> accounts;

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public String getPin() {
        return pin;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }

    public User(String firstName, String name,int id, String pin, ArrayList<Account> accounts) {
        this.firstName = firstName;
        this.name = name;
        this.pin = pin;
        this.id = id;
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return firstName + " " + name;
    }
}

