
public class Chef extends Angestellter {

    private String abteilung;

    public Chef(Person person, String abteilung)
    {
        super(person);
        this.abteilung = abteilung;
    }

    @Override
    public void print()
    {
        System.out.println(person.toString() + " " + abteilung);
    }

    @Override
    public int berechenFerien(int age) {

        if (age >= 55)
        {
            return 6;
        }

        if (age >= 45)
        {
            return 5;
        }

        return 4;
    }

}
