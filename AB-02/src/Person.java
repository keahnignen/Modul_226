public class Person {

    private String vorname;
    private String nachname;
    private int personal;
    private int age;

    public Person(String vorname, String nachname, int personal, int age)
    {
        this.vorname = vorname;
        this.nachname = nachname;
        this.personal = personal;
        this.age = age;
    }

    @Override
    public String toString()
    {
        return vorname + " " + nachname + " " + personal;
    }


}
