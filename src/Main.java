import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Петров", "Иван", 1, "0222");
        User user2 = new User("Весилевский","Сергей", 2, "1111");
        User user3 = new User("Иванов", "Дмитрий", 3, "2222");
        User user4 = new User("Демидов", "Пётр", 4, "4444");

        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        Account account1 = new Account("Count1", 200000, "MyBank");
        Account account2 = new Account("Count2", 12334.32, "AlphaBank");
        Account account3 = new Account("Count3", 21332.23, "SberBank");
        Account account4 = new Account("Count4", 21332.23, "MyBank");
        Account account5 = new Account("Count5", 2343244, "MyBank");

        bankAccount.put(user1.getId(), new ArrayList<Account>(Arrays.asList(account1, account2)));
        bankAccount.put(user2.getId(), new ArrayList<Account>(List.of(account3)));
        bankAccount.put(user3.getId(), new ArrayList<Account>(List.of(account4)));
        bankAccount.put(user4.getId(), new ArrayList<Account>(List.of(account5)));

        MyBank myBank = new MyBank();
    }
}