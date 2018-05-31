public class Fachangstellter extends Angestellter {

    private Chef vorgesetzter;

    public Fachangstellter(Person person, Chef vorgesetzter)
    {
        super(person);
        this.vorgesetzter = vorgesetzter;
    }

    @Override
    public void print()
    {
        System.out.println(person.toString() + " " + vorgesetzter);

    }

    @Override
    public int berechenFerien(int age) {

        if (age >= 60)
        {
            return 6;
        }

        if (age >= 50)
        {
            return 5;
        }

        return 4;
    }


}
