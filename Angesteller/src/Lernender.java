public class Lernender extends Angestellter {

    private int lehrjahr;

    public Lernender(Person person, int lehrjahr)
    {
        super(person);
        this.lehrjahr = lehrjahr;
    }

    @Override
    public void print()
    {
        System.out.println(person.toString() + " " + lehrjahr);
    }

    @Override
    public int berechenFerien(int age) {

        return 5;
    }


}
