import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyBank myBank = new MyBank();

        User user1 = new User("Петров", "Иван", 1, "0222", new ArrayList<Account>(
                Arrays.asList(
                    new Account("account1",212323,"MyBank",null),
                    new Account("account2", 1123,"Sber",null)
                )
            )
        );

        User user2 = new User("Седых","Сергей", 2, "2222", new ArrayList<>(
                Arrays.asList(
                            new Account("account1", 21323, "Sber", null),
                            new Account("account2", 123213,"MyBank", null)
                )
            )
        );

        User user3 = new User("Иванов", "Дмитрий", 3,"9823",new ArrayList<>(
                Arrays.asList(
                        new Account("account1", 23123,"MyBank", null),
                        new Account("account2",13213.21, "Tink", null),
                        new Account("account3", 123123,"MyBank", null)
                )
            )
        );

        User user4 = new User("Демидов", "Пётр", 4, "2322", new ArrayList<>(
                List.of(
                        new Account("account1", 123123, "Sber", null)
                )
            )
        );

        User user5 = new User("Мамедов", "Эмиль", 5, "2132", new ArrayList<>(
                Arrays.asList(
                        new Account("account1", 32132, "MyBank", null),
                        new Account("account2", 31233, "MyBank", null)
                )
        ));

        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("\nВыберите действие");
            System.out.println("1 - Проверить счёт \n2 - Положить средства \n3 - Снять средства \n4 - Перевести средства");
                try {
                    switch (Integer.parseInt(scanner.next())) {
                        case 1:
                            System.out.println("Выберите кто проверяет баланс");
                            myBank.checkBalance(chooseUser(users));
                            continue;
                        case 2: {
                            try {
                                System.out.println("Выберите кому пополнить счет, а после введите сумму для пополнения");
                                myBank.depositBalance(chooseUser(users));
                                continue;
                            } catch (Exception ex) {
                                continue;
                            }
                        }
                        case 3: {
                            try {
                                System.out.println("Выберите у кого снять средства, а после введите сумму для снятия");
                                myBank.withdraw(chooseUser(users));
                                continue;
                            } catch (Exception ex) {
                                continue;
                            }
                        }
                        case 4: {
                            try {
                                System.out.println("Выберите кто переводит средства");
                                User chooseInUser = chooseUser(users);
                                System.out.println("Выберите кому перевести средства");
                                User choosUser = chooseUser(users);
                                System.out.println("Введите сумму");
                                myBank.transferMoney(chooseInUser, choosUser);
                                continue;
                            } catch (Exception ex) {
                                continue;
                            }
                        }
                    }
                }
                catch (Exception ex){
                    continue;
                }
            }
        }
    private static User chooseUser(ArrayList<User> users){
        while (true) {
            try {
                if (users.size() > 1) {
                    for (User user : users) {
                        System.out.println(users.indexOf(user) + " " + user.toString());
                    }
                    Scanner scanner = new Scanner(System.in);
                    return users.get(scanner.nextInt());
                } else if (users.isEmpty()) {
                    return null;
                } else return users.getFirst();
            } catch (Exception ex) { continue; }
        }
    }
}