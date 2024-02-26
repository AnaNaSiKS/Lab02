import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<User,Account> users = new HashMap<>();
        MyBank myBank = new MyBank();
        User user = new User("FFFF","dddd",21323,"0201");
        User user2 = new User("dsds","dasdss",2313,"0213");
        User user3 = new User("asd","gsfd",213,"4213");
        System.out.println(user);
        System.out.println(user2);
        Account account = new Account("kkkk",202020,"MyBank2");
        myBank.checkBalance(user, account);
        myBank.depositBalance(user,account,10000);
        myBank.withdraw(user, account, 202020);
    }
}