import static org.junit.jupiter.api.Assertions.*;

class AccountTest {


    @org.junit.jupiter.api.Test
    void allTestMethods() {
        depositSuccesfull(Double.MAX_VALUE / 2);
        depositSuccesfull(Double.MAX_VALUE);
        depositSuccesfull(Double.MAX_VALUE * 2);
        depositError(Double.MAX_VALUE / 2);
        depositError(Double.MAX_VALUE);
        depositError(Double.MAX_VALUE * 2);
        payInterestSuccssfull(Integer.MAX_VALUE-1);
        payInterestSuccssfull(Integer.MAX_VALUE);
        payInterestError(Integer.MAX_VALUE+1);
        payInterestError(-10);
    }

    @org.junit.jupiter.api.Test
    void depositSuccesfull(double value) {
        Account account = new Account(1, new Client(1, "Max", "Muster"));
        account.deposit(value);
        assertEquals(account.getBalance(), value);
    }

    @org.junit.jupiter.api.Test
    void depositError(double value)
    {
        Account account = new Account(1, new Client(1, "Max", "Muster"));
        account.deposit(value);
        account.deposit(value);
        //System.out.println(value);
        //System.out.println(account.getBalance());
        if (account.getBalance() != Double.POSITIVE_INFINITY)
            assertNotEquals(account.getBalance(), value);
    }

    @org.junit.jupiter.api.Test
    void payInterestSuccssfull(int days) {

        Account account = new Account(1, new Client(1, "Max", "Muster"));
        account.payInterest(days);
        assertEquals(account.getBalance(), 0);

        account = new Account(1, new Client(1, "Max", "Muster"));
        double money = 200;
        account.deposit(money);
        account.payInterest(days);
        assertNotEquals(account.getBalance(), money);
        assertTrue(account.getBalance() > money);

        account = new Account(1, new Client(1, "Max", "Muster"));
        money = 50000;
        account.deposit(money);
        account.payInterest(days);
        assertEquals(account.getBalance(), money);
    }

    @org.junit.jupiter.api.Test
    void payInterestError(int days)
    {
        Account account = new Account(1, new Client(1, "Max", "Muster"));
        account.payInterest(days);
        assertEquals(account.getBalance(), 0);

        account = new Account(1, new Client(1, "Max", "Muster"));
        double money = 200;
        account.deposit(money);
        account.payInterest(days);
        assertTrue(account.getBalance() < money);

        account = new Account(1, new Client(1, "Max", "Muster"));
        money = 50000;
        account.deposit(money);
        account.payInterest(days);
        assertEquals(account.getBalance(), money);

    }
}