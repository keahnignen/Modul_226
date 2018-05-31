public class TestKonto {

    private static Bank bank = new Bank();

    public static void main(String[] args) {
        Account account1 = new Account(1, new Client(1, "Meier", "Hans"));
        //account1.deposit(500.75);
        //account1.payInterest(365);
        Account account2 = new Account(1, new Client(1, "Meyer", "Hans"));
        //account2.deposit(720.50);
        //account2.payInterest(750);

        account1.deposit(505.7575);
        account1.printInformations();
        account2.deposit(748.9252054794521);
        account2.printInformations();
        //account2.payInterest(73);
        account2.deposit(150);
        account2.printInformations();
    }
}
