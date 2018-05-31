public abstract class Angestellter {

    protected Person person;

    public Angestellter(Person person)
    {
        this.person = person;
    }


    public void print()
    {
        System.out.println(person.toString());
    }

    public abstract int berechenFerien(int age);


}
