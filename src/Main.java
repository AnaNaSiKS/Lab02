import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        MyBank myBank = new MyBank();
        User user = new User("FFFF","dddd",102,"0201");
        Account account = new Account("kkkk",202020,"MyBank");
        HashMap<Account,User> users = new HashMap<>();
        users.put(account,user);
        myBank.checkBalance(account,user);
    }
}