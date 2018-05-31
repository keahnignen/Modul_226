
public class Account {


    public Account(double interestRate, Client client)
    {
        this.interestRate = interestRate;
        this.client = client;
    }

    private static final int balanceLimitation = 50000;

    private final Client client;
    private final double interestRate;

    private double balance = 0;


    public void deposit(double value)
    {
        balance += value;
    }

    public void payInterest(int durationInDays) {
        if (balance < balanceLimitation)
            balance += balance * interestRate * durationInDays / 365;
    }

    public void printInformations()
    {
        System.out.println("Der Kunde " + client.name + " hat ein Konto.");
        System.out.println("Der Saldo des Kontos ist " + balance );
    }

    public double getBalance() { return balance; }

}
