public interface ATMMachine {
    public void checkBalance(User user, Account account );
    public void depositBalance(User user, Account account, double money);
    public void withdraw(User user,Account account, double money);
    public void transferMoney(User inUser,Account inAccount, User outUser,Account outAccount, double money);
}
