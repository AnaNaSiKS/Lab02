import java.util.Scanner;

public class MyBank implements ATMMachine {
    private final String BANK_NAME = "MyBank";

    public void checkBalance(User user) {
        if (checkPin(user))
            System.out.println(" Текущий баланс: " + chooseAccount(user).getBalance());
    }

    public void depositBalance(User user) {
        Scanner scanner = new Scanner(System.in);
        try {
            if (checkPin(user)) {
                System.out.println("Выберите аккаунт");
                Account chooseAccount = chooseAccount(user);
                System.out.println("Введите сумму для пополнения");
                double money = Double.parseDouble(scanner.next());
                chooseAccount.setBalance(chooseAccount.getBalance() + money);
                System.out.println(" Текущий баланс: " + chooseAccount.getBalance());
            }
        } catch (Exception ignored) {
            System.out.println("Ошибка! Отмена операции");
        }
    }

    public void withdraw(User user) {
        Scanner scanner = new Scanner(System.in);
        try {
            if (checkPin(user)) {
                System.out.println("Выберите аккаунт");
                Account chooseAccount = chooseAccount(user);
                System.out.println("Введите сумму для снятия");
                double money = Double.parseDouble(scanner.next());
                if (chooseAccount.getBankName().equals(BANK_NAME)) {
                    if (chooseAccount.getBalance() >= money) {
                        chooseAccount.setBalance(chooseAccount.getBalance() - money);
                        System.out.println("Снято: " + money + "Комиссия 0%" + " Текущий баланс: " + chooseAccount.getBalance());
                    } else System.out.println("Недостаточно средств");
                } else {
                    if (chooseAccount.getBalance() >= (money * 1.02)) {
                        chooseAccount.setBalance(chooseAccount.getBalance() - money * 1.02);
                        System.out.println("Снято: " + money + " Комиссия 2%" + " Текущий баланс: " + chooseAccount.getBalance());
                    } else System.out.println("Недостаточно средств");
                }
            }
        } catch (Exception ignored) {
            System.out.println("Ошибка! Отмена операции");
        }
    }

    public void transferMoney(User inUser, User outUser) {
        Scanner scanner = new Scanner(System.in);
        try {
            if (checkPin(inUser)) {
                System.out.println("Выберите с какого счета будут переводиться средства");
                Account chooseInAccount = chooseAccount(inUser);
                System.out.println("Выберите на какой счет перевести средства");
                Account chooseOutAccount = chooseAccount(outUser);
                System.out.println("Введите сумму для перевода");
                double money = Double.parseDouble(scanner.next());
                if (chooseInAccount.getBalance() >= money) {
                    chooseInAccount.setBalance(chooseInAccount.getBalance() - money);
                    chooseOutAccount.setBalance(chooseOutAccount.getBalance() + money);
                    System.out.println(inUser.getFirstName() + " " + inUser.getName() + " " + chooseInAccount.getName()
                            + " Перевёл: " + money +
                            " Кому: " + outUser.getFirstName() + " " + outUser.getName() + " " + chooseOutAccount.getName());
                } else System.out.println("Недостаточно средств");
            }
        } catch (Exception ignored) {
            System.out.println("Ошибка! Отмена операции");
        }
    }

    public boolean checkPin(User user) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите пин-код");
                if (user.getPin().equals(scanner.next()))
                    return true;
                System.out.println("Неверный пин-код");
            } catch (Exception ignored) {
            }
        }
    }

    @Override
    public Account chooseAccount(User user) {
        while (true) {
            try {
                if (user.getAccounts().size() > 1) {
                    int i = 1;
                    for (Account account : user.getAccounts()) {
                        System.out.println(i + " " + account.toString());
                        i++;
                    }
                    Scanner scanner = new Scanner(System.in);
                    return user.getAccounts().get(scanner.nextInt() - 1);
                } else if (user.getAccounts().isEmpty()) {
                    return null;
                } else return user.getAccounts().getFirst();
            } catch (Exception ignored) {
            }
        }
    }
}
