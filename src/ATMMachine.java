public interface ATMMachine {
    public void checkBalance(Account account, User user);
    public boolean depositBalance(User user, double money);
    public boolean withdraw(User user, double money);
    public boolean transferMoney(User inUser, User outUser, double money);
}
