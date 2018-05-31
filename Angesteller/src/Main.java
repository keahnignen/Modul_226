public class Main {

    public static void main(String[] args) {


        Person p = new Person("Hans", "Ueli", 1, 23);

        Lernender l = new Lernender(p, 23);
        Chef chef = new Chef(p, "asd");
        Fachangstellter fachangstellter = new Fachangstellter(p, chef);
        Angestellter a = new Fachangstellter(p, chef);




        Angestellter[] angestellters = new Angestellter[] {  l, chef, a };

        for (Angestellter angestellter: angestellters) {
             System.out.println(angestellter.berechenFerien(45));
             angestellter.print();
        }
    }
}
